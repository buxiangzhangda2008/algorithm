package com.example.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.JavaNioAccess;
import sun.misc.SharedSecrets;

import java.io.File;
import java.io.IOException;
import java.lang.management.BufferPoolMXBean;
import java.lang.management.ManagementFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

@SpringBootTest
class LuceneApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void createIndex() throws IOException {
        List<Book> list = new LinkedList<>();
        //模拟数据
        for (int i = 0; i < 2; i++) {
            Book b = new Book();
            b.setId(i);
            b.setDescription("i  " + i);
            b.setName("java" + i * 10);
            b.setPic("中国" + i * 2);
            b.setPrice(Float.valueOf(i));
            list.add(b);
        }
        //构建Document对象，将数据存入document对象中
        List<Document> documentList = new ArrayList<Document>();
        Document document;
        for (Book book : list) {
            document = new Document();
            //构建field域，理解这一步有利于solr域的理解
            Field id = new StringField("id", book.getId().toString(), Field.Store.YES);
            Field name = new TextField("name", book.getName(), Field.Store.YES);
            Field price = new FloatDocValuesField("price", book.getPrice());
            Field pic = new StoredField("pic", book.getPic());
            Field description = new TextField("description",
                    book.getDescription(), Field.Store.YES);
            // 将field域设置到Document对象中
            document.add(id);
            document.add(name);
            document.add(price);
            document.add(pic);
            document.add(description);
            documentList.add(document);
        }
        //构建分词器，对document进行分词
        Analyzer analyzer = new StandardAnalyzer();
        //配置IndexWriter
        IndexWriterConfig cfg = new IndexWriterConfig(analyzer);
        cfg.setUseCompoundFile(false);
        //指定索引库的地址
        File indexFile = new File("../");
        Directory directory = FSDirectory.open(indexFile.toPath());
        //IndexWriter对象，负责对索引的建立，更新
        IndexWriter writer = new IndexWriter(directory, cfg);
        //分词建立索引，并且添加到索引库中
        for (Document doc : documentList) {
            writer.addDocument(doc);
        }
        writer.close();
    }

    private void indexDocs(IndexWriter writer) throws IOException{
        List<Book> list = new LinkedList<>();
        //模拟数据
        for (int i = 0; i < 2; i++) {
            Book b = new Book();
            b.setId(i);
            b.setDescription("i  " + i);
            b.setName("java" + i * 10);
            b.setPic("中国" + i * 2);
            b.setPrice(Float.valueOf(i));
            list.add(b);
        }
        //构建Document对象，将数据存入document对象中
        List<Document> documentList = new ArrayList<Document>();
        Document document;
        for (Book book : list) {
            document = new Document();
            //构建field域，理解这一步有利于solr域的理解
            Field id = new StringField("id", book.getId().toString(), Field.Store.YES);
            Field name = new TextField("name", book.getName(), Field.Store.YES);
            Field price = new FloatDocValuesField("price", book.getPrice());
            Field pic = new StoredField("pic", book.getPic());
            Field description = new TextField("description",
                    book.getDescription(), Field.Store.YES);
            // 将field域设置到Document对象中
            document.add(id);
            document.add(name);
            document.add(price);
            document.add(pic);
            document.add(description);
            documentList.add(document);
        }
        for (Document doc : documentList) {
            writer.addDocument(doc);
        }
    }
    @Test
    public void indexDel() throws IOException {
        //指定索引库
        File file = new File("../");
        Directory directory = FSDirectory.open(file.toPath());
        //构建分词器，对document进行分词
        Analyzer analyzer = new StandardAnalyzer();
        //配置IndexWriter
        IndexWriterConfig cfg = new IndexWriterConfig(analyzer);
        cfg.setUseCompoundFile(false);
        IndexWriter writer = new IndexWriter(directory, cfg);
        indexDocs(writer);//docDir 中只有两篇文档
        writer.commit();//提交两篇文档，形成_0 段。
        writer.deleteDocuments(new Term("name", "java10"));//删除文档二
        writer.commit();
        // 提交删除，形成_0_1.del
        indexDocs(writer);//再次索引两篇文档，Lucene 不能判􏰁文档与文档的不同，因而算两 篇新的文档。
        writer.commit();//提交两篇文档，形成_1 段

        writer.deleteDocuments(new Term("name", "java10"));//删除文档二
        writer.commit();//提交删除，形成_0_1.del
        writer.flush();
        indexDocs(writer);//索引两篇文档，一篇包􏰇"school"，另一篇包􏰇"beer"
        writer.commit();//提交两篇文档到索引文件，形成段(Segment) "_0"

        writer.deleteDocuments(new Term("name", "java10"));//删除包􏰇"school"的文档，其实是删 除了两篇文档中的一篇。
        writer.commit();//提交删除到索引文件，形成"_0_1.del"

        writer.deleteDocuments(new Term("name", "java10"));//删除包􏰇"beer"的文档，其实是删除了 两篇文档中的另一篇。
        writer.commit();//提交删除到索引文件，形成"_0_2.del"

        indexDocs(writer);//索引两篇文档，和上次的文档相同，但是 Lucene 无法区分，认为 是另外两篇文档。
        writer.commit();//提交两篇文档到索引文件，形成段"_1"


        writer.deleteDocuments(new Term("contents", "beer"));//删除包􏰇"beer"的文档，其中段"_0"已 经无可删除，段"_1"被删除一篇。
        writer.close();//提交删除到索引文件，形成"_1_1.del"
    }
    @Test
    public void indexSearch() throws ParseException, IOException {
        // 创建query对象
        // 使用QueryParser搜索时，需要指定分词器，搜索时的分词器要和索引时的分词器一致
        // 第一个参数：默认搜索的域的名称
        QueryParser parser = new QueryParser("name", new StandardAnalyzer());
        // 通过queryParser来创建query对象
        // 参数：输入的lucene的查询语句
        Query query = parser.parse("name:java10");
        //指定索引库
        File file = new File("../");
        Directory directory = FSDirectory.open(file.toPath());
        //创建IndexReader
        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
        //通过search在索引库中查询
        TopDocs topDocs = searcher.search(query, 10);
        // 根据查询条件匹配出的记录总数
        long count = topDocs.totalHits;
        System.out.println("匹配总条数：" + count);
        // 根据查询条件匹配出的记录
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            // 获取文档的ID
            int docId = scoreDoc.doc;

            // 通过ID获取文档
            Document doc = searcher.doc(docId);
            System.out.println("商品ID：" + doc.get("id"));
            System.out.println("商品名称：" + doc.get("name"));
            System.out.println("商品价格：" + doc.get("price"));
            System.out.println("商品图片地址：" + doc.get("pic"));
            System.out.println("==========================");
            // System.out.println("商品描述：" + doc.get("description"));
        }
        // 关闭资源
        reader.close();

    }
    @Test
    public void indexDeleter() throws Exception{
        //指定索引库
        File file = new File("../");
        Directory directory = FSDirectory.open(file.toPath());
        //构建分词器，对document进行分词
        Analyzer analyzer = new StandardAnalyzer();
        //配置IndexWriter
        IndexWriterConfig cfg = new IndexWriterConfig(analyzer);
        cfg.setUseCompoundFile(true);
        cfg.setMergePolicy(new MergePolicy() {
        })
//        cfg.setMergePolicy(MergePolicy.OneMerge);
        IndexWriter writer = new IndexWriter(directory, cfg);
        indexDocs(writer);
        writer.commit();
        System.out.println("jffjjfjf");
    }
}
