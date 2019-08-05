import java.util.*;
import java.util.Collections;
import java.util.function.*;
//import java.util.date;
interface FunctionalInterface
{
	void display();
}
class TestDemo1
{
	public static void main(String[] args)
	{

		//anonymous inner class approach
		FunctionalInterface i1=new FunctionalInterface()
		{
			public void display()
			{
				System.out.println("anonymous inner class approach");
			}
		};
		//i1.display();

		//Lambda expression approach

		FunctionalInterface i2=()->System.out.println("lambda expression executed");
		i2.display();
	}
}

class TestDemo2
{
	public static void main(String[] args)
	{
		TestDemo2 td=new TestDemo2();

		MathOperation addition=(a,b)->{return a+b;};
		MathOperation substraction=(a,b)->{return a-b;};
		MathOperation multiplication=(a,b)->{return a*b;};
		MathOperation division=(a,b)->{return a/b;};

		System.out.println("a + b : "+td.operateOnMathOperation(10,20,addition));
		System.out.println("a - b : "+td.operateOnMathOperation(10,20,substraction));
		System.out.println("a * b : "+td.operateOnMathOperation(10,20,multiplication));
		System.out.println("a / b : "+td.operateOnMathOperation(200,20,division));

		GreetingMessage msg=(String messsae)->{System.out.println("hello "+messsae);};
		msg.passMessage("newbee");
	}
	interface MathOperation
	{
		int operate(int a,int b);
	}
	interface GreetingMessage
	{
		void passMessage(String messsae);
	}
	private int operateOnMathOperation(int a,int b,MathOperation mo)
	{
		return mo.operate(a,b);
	}
}

interface I2
{
	void m1();
}


class TestDemo3
{
	public static void main(String[] args)
	{
		I2 i=()->System.out.println("I2 interface m1() method");
		i.m1();
	}
}

class TestDemo4
{
	public static void main(String[] args) {
		
		TestDemo4 td=new TestDemo4();
		I add=(x,y)->x+y;
		I substarct=(x,y)->x-y;
		I multiply=(x,y)->x*y;
		I divide=(x,y)->x/y;

		System.out.println("Additon of 20 and 40 is : "+td.operateOnTheNumbers(20,40,add));
		System.out.println("Substraction of 100 from 250 is : "+td.operateOnTheNumbers(250,100,substarct));
		System.out.println("Multiplication of 5 and 12 is : "+td.operateOnTheNumbers(5,12,multiply));
		System.out.println("Division of 3000 by 50 is : "+td.operateOnTheNumbers(3000,50,divide));

	}
	interface I
	{
		int operate(int x,int y);
	}
	private  int operateOnTheNumbers(int x,int y,I i)
	{
		return i.operate(x,y);
	}
}

interface Interf
{
	int squareNum(int num);
	default void show1()
	{
		System.out.println("default method...");
	}
	public static void show2()
	{
		System.out.println("static method...");
	}
}
class Test6
{
	public static void main(String[] args) {
		
		Interf in=(n)->n*n;
		System.out.println(in.squareNum(25));

	}
}


//@FunctionalInterface
interface Interf1
{
	void m();
	//void n();
}
interface Interf2 extends Interf1
{
	//void n();
}
class Test7
{
	public static void main(String[] args) {
		
		Interf2 in=()->System.out.println("lambdas...");
		in.m();
	}
}

class Test8
{
	public static void main(String[] args)
	{
		Runnable r=()->
		{
			for (int i=1;i<=10;i++)
			{
				System.out.println("Child thread...");
			}
		};
		Thread th=new Thread(r);
		th.start();
		for (int i=1;i<=10;i++)
			{
				System.out.println("Main thread...");
			}
	}
}



class Test9
{
	public static void main(String[] args)
	{
		List<Integer> list=new ArrayList<Integer>();
		list.add(25);
		list.add(0);
		list.add(20);
		list.add(10);
		list.add(5);
		list.add(15);
		System.out.println(list);

		Comparator<Integer> com=(i1,i2)->(i1<i2)?-1:(i1>i2)?+1:0;

		Collections.sort(list,com);

		System.out.println(list);
	}
}
class Employee
{
	String ename;
	int eid;
	public Employee(String ename,int eid)
	{
		this.ename=ename;
		this.eid=eid;
	}
	public String toString()
	{
		return this.ename+":"+this.eid;
	}
}
class Test10
{
	public static void main(String[] args)
	{
		List<Employee> list=new ArrayList<Employee>();
		list.add(new Employee("Prakash",125));
		list.add(new Employee("Suraj",109));
		list.add(new Employee("Deepak",103));
		list.add(new Employee("Krishna",146));
		list.add(new Employee("Prateek",154));
		list.add(new Employee("Abinash",133));
		list.add(new Employee("Satya",110));
		System.out.println(list);
		Comparator<Employee> com=(e1,e2)->(e1.eid>e2.eid)?+1:(e1.eid<e2.eid)?-1:0;

		Collections.sort(list,com);	
		System.out.println(list);
		Collections.sort(list,(e1,e2)->e1.ename.compareTo(e2.ename));
		System.out.println(list);
	}
}
interface Interf3
{
	void m1();
	void m2();
	default void m3(){
		System.out.println("default method inside Interf3..");
	}
}
class Test10a implements Interf3
{
	public void m1(){
		System.out.println("m1 method overriden inside Test10a");
	}
	public void m2(){
		System.out.println("m2 method overriden inside Test10a");
	}
}
class Test11 implements Interf3
{
	public void m1(){
		System.out.println("m1 method overriden inside Test11");
	}
	public void m2(){
		System.out.println("m2 method overriden inside Test11");
	}
}
class Test12 implements Interf3
{
	public void m1(){
		System.out.println("m1 method overriden inside Test12");
	}
	public void m2(){
		System.out.println("m2 method overriden inside Test12");
	}
}
class Test13 implements Interf3
{
	public void m1(){
		System.out.println("m1 method overriden inside Test13");
	}
	public void m2(){
		System.out.println("m2 method overriden inside Test13");
	}
	public static void main(String[] args) {
		Test10a t1=new Test10a();
		Test11 t2=new Test11();
		Test12 t3=new Test12();
		Test13 t4=new Test13();

		t1.m1();
		t1.m2();
		t2.m1();
		t2.m2();
		t3.m1();
		t3.m2();
		t4.m1();
		t4.m2();
		t4.m3();
	}
}
class Test14
{
	//default void m(){
		//System.out.println("can we declare default method inside a class ??????");


		/*
		We can't declare defult methos inside a class.
		*/
	//}
}

interface Interf4
{
	/*
	default int hashCode()
	{
		return 10;
	}
	*/
}

/*
error :  LambdaExp.java:296: error: default method hashCode in interface Interf4 overrides a member of java.lang.Object
        default int hashCode()
 */
interface Interf5
{
	default void m()
	{
		System.out.println("defult method inside Interf5.");
	}
}
interface Interf6
{
	default void m()
	{
		System.out.println("default method inside Interf6.");
	}
}
class Test16 implements Interf5,Interf6
{
	public void m(){
		System.out.println("our own implementation for default method m().");
	}

	void display()
	{
		Interf5.super.m();
		Interf6.super.m();
	}
	public static void main(String[] args) {

		Test16 t=new Test16();
		t.m();
		t.display();
	}
}

interface Interf7
{
	static void m()
	{
		System.out.println("static method inside Interf7.");
	}
}
class Test17 implements Interf7
{
	public static void main(String[] args) {
		
		/*
		The following way to invoke static method of an interface inside its imlementation class are invlid.

		//Test17.m();
		Test17 i=new Test17();
		i.m();
		m();*/


		//The following statement to invoke the static method of an  interface.
		Interf7.m();
	}
}

// we can declare main method inside an interface and we can comple & run it .  This feature is introduced in java-8.

interface Interf8
{
	public static void main(String[] args) {
		

		System.out.println("we can declare main method inside an interface.");
		System.out.println("This feature is introduced in java - 8  version.");
	}
}

class Test18
{
	public static void main(String[] args) {
		
		int [] numbers={0,5,10,15,20,25,30,35,40,45,50};
		
		Predicate<Integer> p1=(i)->i%2==0;
		Predicate<Integer> p2=(i)->i%10==0;
		Predicate<Integer> p3=(i)->i>20;

		String[] names={"Lokanath","Uendra","Sambit","Susil","Sandipani","Kanhu","Suraj","Satya","Ramakanta"};
		Predicate<String> p4=(str)->str.length()>5;
		Predicate<String> p5=(str)->str.contains("S");
		Predicate<String> p6=(str)->str.length()<=5;

		System.out.println("the even numbers from the array are :");
		for(int i:numbers)
		{
			if(p1.test(i))
			{
				System.out.println(i+" is even number.");
			}
			else
			{
				System.out.println(i+" is odd number.");
			}
		}
		System.out.println("The numbers which are divisible by 10 are :");
		for(int i:numbers)
		{
			if(p2.test(i))
			{
				System.out.println(i+" is divisible by 10.");
			}
			else
			{
				System.out.println(i+" is not divisible by 10.");
			}
		}
		System.out.println("the numbere which are greater than 20 are :");
		for(int i:numbers)
		{
			if(p3.test(i))
			{
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println("The Strings having more than 5 letters are :");
		for(String s:names)
		{
			if(p4.test(s))
			{
				System.out.print(s+" , ");
			}
		}
		System.out.println();
		System.out.println("The Strings having letter 's' are :");
		for(String s:names)
		{
			if(p5.test(s))
			{
				System.out.print(s+" , ");
			}
		}	
		System.out.println();
		System.out.println("The numbers that are divisible both by 2 nd 10 are : ");
		for(int i:numbers)
		{
			if(p1.and(p2).test(i))
			{
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println("The numbers that are divisible either divisibe by 2 or greater than 20 are  : ");
		for(int i:numbers)
		{
			if(p1.or(p3).test(i))
			{
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println("The numbers that are smaler than 20 are  : ");
		for(int i:numbers)
		{
			if(p1.negate().test(i))
			{
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println("The Strings having more than 5 letters are  : ");
		for(String s:names)
		{
			if(p6.negate().test(s))
			{
				System.out.print(s+" ");
			}
		}
	}
}


//Wap using Function to show the length of a String.
class Test19
{
	public static void main(String[] args) {
		
		Function<String,Integer> f1=(String s)->s.length();
		System.out.println("The length of the word : Conciousness is : : "+f1.apply("Conciousness"));
	}
}

// Wap using Function to find out the grade of the student


class Student
{
	String name;
	int marks;
	public Student(String name,int marks)
	{
		this.name=name;
		this.marks=marks;
	}
	public String toString()
	{
		return this.name+"==="+this.marks;
	}
}


class Test20
{
	public static void addStudentsToTheList(List list)
	{
		list.add(new Student("Ravish",78));
		list.add(new Student("Arupananda",88));
		list.add(new Student("Mayadhar",68));
		list.add(new Student("Dinesh",96));
		list.add(new Student("Rashmi",82));
		list.add(new Student("Satya",82));
	}
	public static void main(String[] args)
	{
		
		Function<Integer,Integer> f=(i)->(i<10)?+1:(i<20)?+2:(i<30)?3:+4;
		System.out.println(f.apply(20));
		List<Student> list=new ArrayList<Student>(); 
		Test20.addStudentsToTheList(list);
		Function<Student,String> f1=(Student student)->(student.marks>=90)?"A1 grade": (student.marks>=85)?"A2 grade": (student.marks>=80)?"B1 grade": (student.marks>=75)?"B2 grade":"C grade";
		for (Student s : list) 
		{
			System.out.println("Student's name : "+s.name);
			System.out.println("Student's marks : "+s.marks);
			System.out.println("Student's grade : "+f1.apply(s));
			System.out.println("");
		}
	}
}

//Function chaining

class Test21
{
	public static void main(String[] args) 
	{
		
		Function<Integer,Integer> f1=(i)->2*i;
		Function<Integer,Integer> f2=(i)->i*i;

		System.out.println(f1.andThen(f2).apply(2));
		System.out.println(f1.compose(f2).apply(2));


		//Consumer
		List<Student> list=new ArrayList<Student>();
		list.add(new Student("Ravish",78));
		list.add(new Student("Arupananda",88));
		list.add(new Student("Mayadhar",68));
		list.add(new Student("Dinesh",96));
		list.add(new Student("Rashmi",82));
		list.add(new Student("Satya",82));
		Function<Student,String> f3=(Student student)->(student.marks>=90)?"A1 grade": (student.marks>=85)?"A2 grade": (student.marks>=80)?"B1 grade": (student.marks>=75)?"B2 grade":"C grade";
		Consumer<Student> c=(Student student)->
		{
			System.out.println("student's name : "+student.name);
			System.out.println("student's marks : "+student.marks);
			System.out.println("student's grade : "+f3.apply(student));	
			System.out.println("");
		};
		for (Student student :list ) 
		{
			c.accept(student);			
		}


		//Supplier

		//print the system date using Supplier

		Supplier<Date> s1=()->new Date();
		System.out.println("Today date is : "+s1.get());


		//Generate OTP using Supplier

		Supplier<String> s2=()->
		{
			String otp="";

			for (int i=1;i<=6;i++)
			{
				otp=otp+(int)(Math.random()*10);	
			}
			return otp;
		};

		for(int i=1;i<=5;i++)
		{
			System.out.println(s2.get());
		}

	}
}

class Test22
{
	public static void main(String[] args) {
		
		//BiPredicte

		//Wap to check whether the adddition of 2 numbers is even or not ?

		BiPredicate<Integer,Integer> bp=(Integer i1,Integer i2)->(i1+i2)%2==0;

		Scanner scan=new Scanner(System.in);
		int num1=scan.nextInt();
		int num2=scan.nextInt();
		if(bp.test(num1,num2))
		{
			System.out.println("even");
		}
		else
		{
			System.out.println("odd");
		}


		//BiFunction

		/*Wap using BiFunction to retrn Student object and add the objects to a list then print that list.*/

		BiFunction<String,Integer,Student> bf=(String name,Integer marks)->new Student(name,marks);

		List<Student> list=new ArrayList<Student>();

		list.add(bf.apply("A",100));
		list.add(bf.apply("B",101));
		list.add(bf.apply("C",102));
		list.add(bf.apply("D",103));
		list.add(bf.apply("E",104));
		System.out.println(list);

	}
}


//BiConsumer

//Wap to increase the salary of an employee by 500.

class Employees
{
	String name;
	int salary;
	Employees(String name,int salary)
	{
		this.name=name;
		this.salary=salary;
	}
	public String toString()
	{
		return this.name+"==="+this.salary;
	}
}
class Test23
{
	public static void main(String[] args) {
		
		List<Employees> list=new ArrayList<Employees>();
		list.add(new Employees("A",2000));
		list.add(new Employees("B",3000));
		list.add(new Employees("C",4000));
		list.add(new Employees("D",5000));
		list.add(new Employees("E",6000));

		BiConsumer<Employees,Double> bc=(Employees employee,Double salary)->employee.salary=employee.salary+500;

		for (Employees employee :list )
		{
			bc.accept(employee,500.0);
			System.out.println(employee);	
		}

	}
}