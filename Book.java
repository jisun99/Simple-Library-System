import java.util.ArrayList;
import java.util.Scanner;

public class Book {		// Book Ŭ���� ����
    Scanner sc = new Scanner(System.in);
    private String bNo, bTitle, bAuthor, bPublisher;	// å�� ��ȣ, ����, �۰�, ���ǻ翡 ����  String�� ���� ����
    private ArrayList<Book> bookList = new ArrayList<Book>();	// bookList �迭����Ʈ ����
 
    public Book() {
    }
    
    public String getbNo() {
        return bNo;
    }
 
    public void setbNo(String bNo) {
        this.bNo = bNo;
    }
 
    public String getbTitle() {
        return bTitle;
    }
 
    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }
 
    public String getbAuthor() {
        return bAuthor;
    }
 
    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }
 
    public String getbPublisher() {
        return bPublisher;
    }
 
    public void setbPublisher(String bPublisher) {
        this.bPublisher = bPublisher;
    }
    
 
    public void showMain() throws InterruptedException {
        while (true) {	// �޴�
            System.out.println("==============Library System Menu==============");
            System.out.println("[1] ���� �Է�        [2] ���� ���        [3] ���� �˻�        [4] ���� ����        \n"
            		+ "[5] selection ����             [6] quick ����           [0] ����");
            String selectMenu = sc.nextLine();
            switch (selectMenu) {
            case ("1"):	// ���� �Է�
            	long start1 = System.currentTimeMillis(); //���α׷��� �����ϴ� ���� ���
                insertBook(); 
                long end1 = System.currentTimeMillis(); //���α׷��� ������ ���� ���
                System.out.println( "���� �ð� : " + ( end1 - start1 )/1000.0 +"��");
                
                break;
            case ("2"):	// ���� ���
            	long start2 = System.currentTimeMillis(); //���α׷��� �����ϴ� ���� ���
                selectAll(); 
                long end2 = System.currentTimeMillis(); //���α׷��� ������ ���� ���
                System.out.println( "���� �ð� : " + ( end2 - start2 )/1000.0 +"��");
                
                break;
            case ("3"):	// ���� �˻�
            	long start3 = System.currentTimeMillis(); //���α׷��� �����ϴ� ���� ���
                selectOne(); 
                long end3 = System.currentTimeMillis(); //���α׷��� ������ ���� ���
                System.out.println( "���� �ð� : " + ( end3 - start3 )/1000.0 +"��");
                
                break;
            case ("4"):	// ���� ����
            	long start4 = System.currentTimeMillis(); //���α׷��� �����ϴ� ���� ���
                deletebook();
                long end4 = System.currentTimeMillis(); //���α׷��� ������ ���� ���
            	System.out.println( "���� �ð� : " + ( end4 - start4 )/1000.0 +"��");
            	
                break;
            case ("5"):	// selection ����
            	long start5 = System.currentTimeMillis(); //���α׷��� �����ϴ� ���� ���
            	selectionsort();
            	long end5 = System.currentTimeMillis(); //���α׷��� ������ ���� ���
            	System.out.println( "���� �ð� : " + ( end5 - start5 )/1000.0 +"��");
            	
            	break;
            case ("6"):	// quick ����
            	long start6 = System.currentTimeMillis(); //���α׷��� �����ϴ� ���� ���
            	int [] qsort = new int [bookList.size()];	
        		for(int i=0;i<bookList.size();i++) {
            	qsort[i] = Integer.valueOf(bookList.get(i).getbNo());
            }	// qsort �迭�����, bookList�� ��ҵ��� �Űܳ���
            	quicksort(qsort,0,qsort.length-1);	// qsort�迭�� ������ quick sorting
            	 System.out.println("quick ���� ��� :");
                 for(int i=0; i<qsort.length; i++){
                     System.out.println(qsort[i]);
                 }
                 
                long end6 = System.currentTimeMillis(); //���α׷��� ������ ���� ���
             	System.out.println( "���� �ð� : " + ( end6 - start6 )/1000.0 +"��");
             	
            	break;
            case ("0"):	// ����
            	long start0 = System.currentTimeMillis(); //���α׷��� �����ϴ� ���� ���
                System.out.println("���α׷� ����");
                sc.close();
                long end0 = System.currentTimeMillis(); //���α׷��� ������ ���� ���
             	System.out.println( "���� �ð� : " + ( end0 - start0 )/1000.0 +"��");
             	
                System.exit(0);
            default:
                System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
                break;
            }
     
        } 
        }
    
    // 1. ���� �Է�
    public void insertBook() throws InterruptedException {
        while (true) {
            Book book = new Book();
            // ���� ��ȣ�� �ߺ��Ǹ� �� ��
            while (true) {
                int count=0;
                System.out.println("���� ��ȣ��  �Է��ϼ��� : ");
                String tmp = sc.nextLine();
                for (int i = 0; i < bookList.size(); i++) {
                    if (tmp.equals(bookList.get(i).getbNo())) {
                        count++;
                        System.out.println("�ߺ��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.");
                        break;
                    } // end if
                } // end for
                if(count==0) {
                    book.setbNo(tmp);
                    break;
                }
            } // end while
            System.out.println("������ �Է��ϼ��� : ");
            book.setbTitle(sc.nextLine());
            System.out.println("�۰��� �Է��ϼ��� : ");
            book.setbAuthor(sc.nextLine());
            System.out.println("���ǻ縦 �Է��ϼ��� : ");
            book.setbPublisher(sc.nextLine());
            Thread.sleep(1000);
 
            // ���� �Ŀ� ����Ʈ�� ��ü ����
            System.out.println("������ȣ : " + book.getbNo());
            System.out.println("���� : " + book.getbTitle());
            System.out.println("����  : " + book.getbAuthor());
            System.out.println("���ǻ�  : " + book.getbPublisher());
            System.out.println("�Է��Ͻ� ������ ��� �½��ϱ�? ��(Y) �ƴϿ�(N)");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                bookList.add(book);
                System.out.println("======�Է� �Ϸ�=====");
                break;
            } else if (confirm.equalsIgnoreCase("n")) {
                System.out.println("�ٽ� �Է����ּ���.");
            } else {
                System.out.println("�߸��� �Է��Դϴ�. �ʱ� �޴��� �̵��մϴ�.");
                break; // �ʱ�޴��� �̵�
            } // if-else end
        } // end while
 
        Thread.sleep(1000);
    }// end main
    
    // 2. ���� ���
    public void selectAll() throws InterruptedException {
        while (true) {
            System.out.println("���� ������:  " + bookList.size());
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println("===============================");
                System.out.println("������ȣ : " + bookList.get(i).getbNo());
                System.out.println("���� : " + bookList.get(i).getbTitle());
                System.out.println("����  : " + bookList.get(i).getbAuthor());
                System.out.println("���ǻ�  : " + bookList.get(i).getbPublisher());
                System.out.println("===============================\n");
 
            } // end for
            System.out.println("�ʱ� �޴��� �̵��մϴ�.");
            	break;
        } // while end
    }// end selectAll
    
    // 3. ���� �˻�
    public void selectOne() {
        while (true) {
            System.out.println("�˻� �� ������ ��ȣ�� �Է����ּ��� : ");
            String tmp = sc.nextLine();
            int count = 0;
            for (int i = 0; i < bookList.size(); i++) {
                if (tmp.equals(bookList.get(i).getbNo())) {
                    System.out.println("===============================");
                    System.out.println("������ȣ : " + bookList.get(i).getbNo());
                    System.out.println("���� : " + bookList.get(i).getbTitle());
                    System.out.println("����  : " + bookList.get(i).getbAuthor());
                    System.out.println("���ǻ�  : " + bookList.get(i).getbPublisher());
                    System.out.println("===============================\n");
                    count++;
                    break;
                }
            } // end for
            if (count == 0) {
                System.out.println("�ش� ������ �������� �ʽ��ϴ�. �ʱ� �޴��� �̵��մϴ�.");
                break;
            } else {
                break;// ��������
            }
        } // end while
    }

    // 4. ����
    public void deletebook() {
        while (true) {
            System.out.println("���� �� ������ ��ȣ�� �Է����ּ��� : ");
            String tmp = sc.nextLine();
            int count = 0;
            for (int i = 0; i < bookList.size(); i++) {
                if (tmp.equals(bookList.get(i).getbNo())) {
                    bookList.remove(i);
                    count++;
                    System.out.println("������ �Ϸ�Ǿ����ϴ�.");
                    break;
                }
            } // end for
            if (count == 0) {
                System.out.println("�ش� ������ �������� �ʽ��ϴ�. �ʱ� �޴��� �̵��մϴ�.");
                break;
            } else {
                break;// ��������
            }
        } // end while
 
    } // end delete book

    // 5. selection sort
    public void selectionsort() throws InterruptedException{
        int min; //�ּҰ��� ���� �������� �ε��� ���� ����
        int tmp;
        int [] selsort = new int [bookList.size()];
        for(int i=0;i<bookList.size();i++) {
        	selsort[i] = Integer.valueOf(bookList.get(i).getbNo());
        }

        for(int i=0; i<bookList.size()-1; i++){ // size-1 : ������ ��Ҵ� �ڿ������� ���ĵ�
            min = i;
            for(int j=i+1; j<bookList.size(); j++){
            	//sort[min] = Integer.valueOf(bookList.get(min).getbNo());
            	//sort[j] = Integer.valueOf(bookList.get(j).getbNo());
            	if(selsort[min] > selsort[j]) {
                    min = j;
                }
            }
            tmp = selsort[min];
            selsort[min] = selsort[i];
            selsort[i] = tmp;
        }
        
        System.out.println("selection ���� ��� :");
        for(int i=0;i<bookList.size(); i++) {
        	System.out.println(selsort[i]);
        }
    }
    
    // 6. quick sort
    public void quicksort(int [] qsort, int l, int r) throws InterruptedException{
    	int left = l;
    	int right = r;
    	int pivot = qsort[(l+r)/2];
    	
    	 do{
             while(qsort[left] < pivot) left++;
             while(qsort[right] > pivot) right--;
             if(left <= right){    
                 int temp = qsort[left];
                 qsort[left] = qsort[right];
                 qsort[right] = temp;
                 left++;
                 right--;
             }
         }while (left <= right);
         
         if(l < right) {
        	 quicksort(qsort,l, right);
         }
         if(r > left) {
        	 quicksort(qsort,left, r);    	
         }
         
    }

    public static void main(String[] args) throws InterruptedException {
        Book book = new Book();
        book.showMain();
    }

}
        

    
