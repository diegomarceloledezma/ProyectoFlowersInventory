public class FeedStockCounterXml extends FeedStockCounter {

	@Override
	protected FeedParser buildParser() {
		return new FeedParserXml();
	}

}