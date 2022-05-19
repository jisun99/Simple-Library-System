import java.util.ArrayList;
import java.util.Scanner;

public class Book {		// Book 클래스 생성
    Scanner sc = new Scanner(System.in);
    private String bNo, bTitle, bAuthor, bPublisher;	// 책의 번호, 제목, 작가, 출판사에 대한  String형 변수 생성
    private ArrayList<Book> bookList = new ArrayList<Book>();	// bookList 배열리스트 생성
 
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
        while (true) {	// 메뉴
            System.out.println("==============Library System Menu==============");
            System.out.println("[1] 도서 입력        [2] 도서 출력        [3] 도서 검색        [4] 도서 삭제        \n"
            		+ "[5] selection 정렬             [6] quick 정렬           [0] 종료");
            String selectMenu = sc.nextLine();
            switch (selectMenu) {
            case ("1"):	// 도서 입력
            	long start1 = System.currentTimeMillis(); //프로그램이 시작하는 시점 계산
                insertBook(); 
                long end1 = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
                System.out.println( "실행 시간 : " + ( end1 - start1 )/1000.0 +"초");
                
                break;
            case ("2"):	// 도서 출력
            	long start2 = System.currentTimeMillis(); //프로그램이 시작하는 시점 계산
                selectAll(); 
                long end2 = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
                System.out.println( "실행 시간 : " + ( end2 - start2 )/1000.0 +"초");
                
                break;
            case ("3"):	// 도서 검색
            	long start3 = System.currentTimeMillis(); //프로그램이 시작하는 시점 계산
                selectOne(); 
                long end3 = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
                System.out.println( "실행 시간 : " + ( end3 - start3 )/1000.0 +"초");
                
                break;
            case ("4"):	// 도서 삭제
            	long start4 = System.currentTimeMillis(); //프로그램이 시작하는 시점 계산
                deletebook();
                long end4 = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
            	System.out.println( "실행 시간 : " + ( end4 - start4 )/1000.0 +"초");
            	
                break;
            case ("5"):	// selection 정렬
            	long start5 = System.currentTimeMillis(); //프로그램이 시작하는 시점 계산
            	selectionsort();
            	long end5 = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
            	System.out.println( "실행 시간 : " + ( end5 - start5 )/1000.0 +"초");
            	
            	break;
            case ("6"):	// quick 정렬
            	long start6 = System.currentTimeMillis(); //프로그램이 시작하는 시점 계산
            	int [] qsort = new int [bookList.size()];	
        		for(int i=0;i<bookList.size();i++) {
            	qsort[i] = Integer.valueOf(bookList.get(i).getbNo());
            }	// qsort 배열만들고, bookList의 요소들을 옮겨넣음
            	quicksort(qsort,0,qsort.length-1);	// qsort배열을 가지고 quick sorting
            	 System.out.println("quick 소팅 결과 :");
                 for(int i=0; i<qsort.length; i++){
                     System.out.println(qsort[i]);
                 }
                 
                long end6 = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
             	System.out.println( "실행 시간 : " + ( end6 - start6 )/1000.0 +"초");
             	
            	break;
            case ("0"):	// 종료
            	long start0 = System.currentTimeMillis(); //프로그램이 시작하는 시점 계산
                System.out.println("프로그램 종료");
                sc.close();
                long end0 = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
             	System.out.println( "실행 시간 : " + ( end0 - start0 )/1000.0 +"초");
             	
                System.exit(0);
            default:
                System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
                break;
            }
     
        } 
        }
    
    // 1. 도서 입력
    public void insertBook() throws InterruptedException {
        while (true) {
            Book book = new Book();
            // 도서 번호는 중복되면 안 됨
            while (true) {
                int count=0;
                System.out.println("도서 번호를  입력하세요 : ");
                String tmp = sc.nextLine();
                for (int i = 0; i < bookList.size(); i++) {
                    if (tmp.equals(bookList.get(i).getbNo())) {
                        count++;
                        System.out.println("중복된 번호입니다. 다시 입력하세요.");
                        break;
                    } // end if
                } // end for
                if(count==0) {
                    book.setbNo(tmp);
                    break;
                }
            } // end while
            System.out.println("제목을 입력하세요 : ");
            book.setbTitle(sc.nextLine());
            System.out.println("작가를 입력하세요 : ");
            book.setbAuthor(sc.nextLine());
            System.out.println("출판사를 입력하세요 : ");
            book.setbPublisher(sc.nextLine());
            Thread.sleep(1000);
 
            // 컨펌 후에 리스트에 객체 저장
            System.out.println("도서번호 : " + book.getbNo());
            System.out.println("제목 : " + book.getbTitle());
            System.out.println("저자  : " + book.getbAuthor());
            System.out.println("출판사  : " + book.getbPublisher());
            System.out.println("입력하신 사항이 모두 맞습니까? 예(Y) 아니오(N)");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                bookList.add(book);
                System.out.println("======입력 완료=====");
                break;
            } else if (confirm.equalsIgnoreCase("n")) {
                System.out.println("다시 입력해주세요.");
            } else {
                System.out.println("잘못된 입력입니다. 초기 메뉴로 이동합니다.");
                break; // 초기메뉴로 이동
            } // if-else end
        } // end while
 
        Thread.sleep(1000);
    }// end main
    
    // 2. 도서 출력
    public void selectAll() throws InterruptedException {
        while (true) {
            System.out.println("보유 도서량:  " + bookList.size());
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println("===============================");
                System.out.println("도서번호 : " + bookList.get(i).getbNo());
                System.out.println("제목 : " + bookList.get(i).getbTitle());
                System.out.println("저자  : " + bookList.get(i).getbAuthor());
                System.out.println("출판사  : " + bookList.get(i).getbPublisher());
                System.out.println("===============================\n");
 
            } // end for
            System.out.println("초기 메뉴로 이동합니다.");
            	break;
        } // while end
    }// end selectAll
    
    // 3. 도서 검색
    public void selectOne() {
        while (true) {
            System.out.println("검색 할 도서의 번호를 입력해주세요 : ");
            String tmp = sc.nextLine();
            int count = 0;
            for (int i = 0; i < bookList.size(); i++) {
                if (tmp.equals(bookList.get(i).getbNo())) {
                    System.out.println("===============================");
                    System.out.println("도서번호 : " + bookList.get(i).getbNo());
                    System.out.println("제목 : " + bookList.get(i).getbTitle());
                    System.out.println("저자  : " + bookList.get(i).getbAuthor());
                    System.out.println("출판사  : " + bookList.get(i).getbPublisher());
                    System.out.println("===============================\n");
                    count++;
                    break;
                }
            } // end for
            if (count == 0) {
                System.out.println("해당 도서가 존재하지 않습니다. 초기 메뉴로 이동합니다.");
                break;
            } else {
                break;// 메인으로
            }
        } // end while
    }

    // 4. 삭제
    public void deletebook() {
        while (true) {
            System.out.println("삭제 할 도서의 번호를 입력해주세요 : ");
            String tmp = sc.nextLine();
            int count = 0;
            for (int i = 0; i < bookList.size(); i++) {
                if (tmp.equals(bookList.get(i).getbNo())) {
                    bookList.remove(i);
                    count++;
                    System.out.println("삭제가 완료되었습니다.");
                    break;
                }
            } // end for
            if (count == 0) {
                System.out.println("해당 도서가 존재하지 않습니다. 초기 메뉴로 이동합니다.");
                break;
            } else {
                break;// 메인으로
            }
        } // end while
 
    } // end delete book

    // 5. selection sort
    public void selectionsort() throws InterruptedException{
        int min; //최소값을 가진 데이터의 인덱스 저장 변수
        int tmp;
        int [] selsort = new int [bookList.size()];
        for(int i=0;i<bookList.size();i++) {
        	selsort[i] = Integer.valueOf(bookList.get(i).getbNo());
        }

        for(int i=0; i<bookList.size()-1; i++){ // size-1 : 마지막 요소는 자연스럽게 정렬됨
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
        
        System.out.println("selection 소팅 결과 :");
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
        

    
