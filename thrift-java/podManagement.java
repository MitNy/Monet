import java.io.*;
import java.util.*;

public class podManagement {

	/* shell command */
	public static void shellCmd(String command) throws Exception {
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(command);

		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

	/* create pod */
	public static void AddDmEngine() throws Exception{
		String name;
		String type;
		String alias;
		Scanner scan = new Scanner(System.in);
		System.out.print("pod name : ");
		name = scan.nextLine();
		System.out.print("type : ");
		type = scan.nextLine();
		System.out.print("alias : ");
		alias = scan.nextLine();

		String txt="apiVersion: v1\n"+
			   "kind: Pod\n"+
			   "metadata:\n"+
			   "  name: "+name+"\n"+
			   "  labels:\n"+
			   "    type: "+type+"\n"+
			   "    alias: "+alias+"\n"+
			   "spec:\n"+
			   "  containers:\n"+
			   "  - name: dme-container\n"+
			   "    image: nginx\n"+
			   "    ports:\n"+
			   "    - containerPort: 80";
                String fileName = "test.yaml" ;

                try {
                        BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, false));
                        fw.write(txt);
                        fw.flush();
                        fw.close();

                } catch(Exception e) {
                        e.printStackTrace();
                }

                String command = "kubectl apply -f "+fileName;
		
		shellCmd(command);

	}

	public static void RemoveDmEngine() throws Exception {
		String type;
		String alias;
		Scanner scan = new Scanner(System.in);
		System.out.print("type : ");
                type = scan.nextLine();
                System.out.print("alias : ");
                alias = scan.nextLine();

		String command = "kubectl delete pod -l type="+type+",alias="+alias+"";
		shellCmd(command);

	}

	public static void DescribeDMEngine() throws Exception {
		String type;
		String alias;
		Scanner scan = new Scanner(System.in);
		System.out.print("type : ");
                type = scan.nextLine();
                System.out.print("alias : ");
                alias = scan.nextLine();

		String command = "kubectl describe pod -l type="+type+",alias="+alias+"";
		shellCmd(command);
	}

	public static void main(String[] args) throws Exception {

		System.out.println("--------------------");
		System.out.println("1. Add DM Engine ");
		System.out.println("2. Remove DM Engine ");
		System.out.println("3. Describe DM Engine ");
		System.out.println("--------------------");
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();

		if( input == 1 ) {
			AddDmEngine();
		}
		else if( input == 2 ) {
			RemoveDmEngine();
		}
		else if( input == 3 ) {
			DescribeDMEngine();
		}
	}

}
