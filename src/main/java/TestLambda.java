import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestLambda {
	public static void main(String[] args) {
		Message.test("sss");
		Message message = () -> {
			System.out.println("111");
			System.out.println("222");
			System.out.println("333");
		};
		message.print();
		Add add = (a, b) -> a + b;
		System.out.println(add.add(1, 5));

		//功能型
		Function<Integer, String> function = String::valueOf;
		System.out.println(function.apply(1000));
		//消费型
		Consumer<String> consumer = System.out::println;
		consumer.accept("consumer");
		//供给型
		Supplier<String> supplier = "hello"::toUpperCase;
		System.out.println(supplier.get());
		//断言型
		Predicate<String> predicate = "##hello"::startsWith;
		System.out.println(predicate.test("#"));
	}
}

@FunctionalInterface
interface Message {
	void print();

	static void test(String string) {
		System.out.println(string);
	}
}

@FunctionalInterface
interface Add {
	int add(int a, int b);
}
