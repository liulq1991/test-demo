import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by liulq on 2017/4/19.
 */
public class Test1 {

	@Test
	public void testScriptEngine() {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
		double d;
		try {
			Object o = engine.eval("12.35*1.10");
			d = Double.parseDouble(o.toString());
			System.out.println(d);
		} catch (ScriptException e) {
			System.out.println("无法识别表达式");
		}
	}


	@Test
	public void testRound2() {
		/*BigDecimal b = new BigDecimal(Double.toString(value));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, 2, RoundingMode.HALF_UP).doubleValue();*/
		Double f = 111231.4449D;
		BigDecimal b = new BigDecimal(f);
		Double f1 = b.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
		System.out.println(f1);
	}

	@Test
	public void testExecutors() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		System.out.println("call");
		executorService.execute(new Runnable() {
			public void run() {
				try {
					System.out.println("call 1");
					Thread.sleep(1000);
					System.out.println("call 2");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		executorService.shutdown();
	}
}
