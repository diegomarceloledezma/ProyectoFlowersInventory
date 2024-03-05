public class Main {

    public static void main(String[] args) {
        System.out.println("Inventario de Floreria UPB!!!");


        String CSV_PATH = "data/warehouse-stock.csv";
        FileReaderInventory fileReaderInventory  = new FileReaderInventory(CSV_PATH);
        String csvRecords = fileReaderInventory.readFileContent();

        FeedStockCounterCsv feedStockCounterCsv = new FeedStockCounterCsv();
        System.out.println(feedStockCounterCsv.totalStock(csvRecords));

        String JSON_PATH = "data/warehouse-stock.json";
        FileReaderInventory fileReaderInventoryJson  = new FileReaderInventory(JSON_PATH);
        String jsonRecords =  fileReaderInventoryJson.readFileContent();

        FeedStockCounterJson feedStockCounterJson = new FeedStockCounterJson();
        System.out.println(feedStockCounterJson.totalStock(jsonRecords));
        
        String XML_PATH = "data/warehouse-stock.xml";
        FileReaderInventory fileReaderInventoryXml = new FileReaderInventory(XML_PATH);
        String xmlRecords = fileReaderInventoryXml.readFileContent();
        
        FeedStockCounterXml feedStockCounterXml = new FeedStockCounterXml();
        System.out.println(feedStockCounterXml.totalStock(xmlRecords));

        
        System.out.println(xmlRecords);


        //System.out.println(jsonRecords);
    }

}