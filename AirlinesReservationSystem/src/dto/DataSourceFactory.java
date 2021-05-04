package dto;

public class DataSourceFactory {
	private static DataSource dataSource = null;
	
	public static DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new DataSource();
		}
		return dataSource;
	}
}
