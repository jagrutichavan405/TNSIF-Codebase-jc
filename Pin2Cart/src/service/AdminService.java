package service;

		import java.util.List;
		import model.Product;
		import model.ClickLog;

		public class AdminService {

		    public void viewFlaggedProducts(List<Product> products) {
		        System.out.println("Flagged Products:");
		        for (Product p : products) {
		            if (p.isFlagged()) {
		                System.out.println(p);
		            }
		        }
		    }

		    public void viewClickLogs(List<ClickLog> logs) {
		        System.out.println("Click Logs:");
		        for (ClickLog log : logs) {
		            System.out.println(log);
		        }
		    }
		}
