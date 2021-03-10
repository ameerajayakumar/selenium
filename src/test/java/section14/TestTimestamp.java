package section14;

import java.util.Date;

public class TestTimestamp {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d.toString().replace(":", "_").replace(" ", "_") + ".jpg");
	}

}
