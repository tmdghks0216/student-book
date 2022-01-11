package t1;

import java.util.*;


class Student{
   private int pk;//학번
    private String name;//이름
    private int num;//성적 

   public Student(int pk,String name) {
      this(pk,name,0);
   }
   public Student(int pk,String name,int num) {

      this.name=name;
      this.pk=pk;
      this.num=num;


   }

   
   public int getPk() {
      return pk;
   }
   public void setPk(int pk) {
      this.pk = pk;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   @Override
   public String toString() {
      return "[학번" + pk + " 이름:" + name + " 성적:" + num + "]";
   }


}








public class Board {
   public static void main(String[] args) {
      Random rd=new Random();
      Scanner sc=new Scanner(System.in);
      ArrayList<Student> std=new ArrayList<Student>();
      int pk=10;
      std.add(new Student(pk++,"가",rd.nextInt(101)));
      std.add(new Student(pk++,"나",rd.nextInt(101)));
      std.add(new Student(pk++,"다",rd.nextInt(101)));
      std.add(new Student(pk++,"라",rd.nextInt(101)));
      std.add(new Student(pk++,"마",rd.nextInt(101)));
      while(true) {
         System.out.println("===화면===");
         System.out.println("1. 출석부 출력");
         System.out.println("2. 학생 등록");
         System.out.println("3. 학생 정보 출력");
         System.out.println("4. 학생정보 변경");
         System.out.println("5. 학생 삭제");
         System.out.println("6. 1등학생 이름 출력");
         System.out.println("7. 프로그램 종료");
         System.out.println("========");
         System.out.println("");

         int act=sc.nextInt();


         if(act==1) {
        	   if(std.size()==0) {
                   System.out.println("학생이 0명입니다!");
                   continue;
                }

            Iterator itr=std.iterator();
            while(itr.hasNext()) {
               System.out.println(itr.next()); 
            }

         }else if(act==2) {
            System.out.print("이름을 입력해주세요>>");
            String name=sc.next();
            System.out.println("성적을 입력하시겠습니까? Y/N");
            String YN=sc.next();
            YN=YN.toUpperCase();
            if(YN.equals("N")) {
               std.add(new Student( pk++ ,name));
            }else {
               std.add(new Student(pk++,name,rd.nextInt(101)));
            }
            System.out.println("등록되었습니다.");


         }else if(act==3) {
            boolean flge=true;
            int pk1;
            while(true) {
               
               System.out.println("출력할 학생의 번호를 입력하세요.");
               System.out.print("번호 입력>>> ");
               pk1=sc.nextInt();
               if(0<pk1 && pk1<30) { // 종료조건
                  break;
               }
               System.out.println("잘못된 범위입력입니다! 확인후 다시입력해보세요!");
            }
            
            for(int i=0;i<std.size();i++) {
               if(pk1==std.get(i).getPk()) {
                  System.out.println(std.get(i));
                  System.out.println("출력완료!!");
                  flge=false;
                  break;
               }
            }
            if(flge) {
               System.out.println("없는 학번 입니다.");
            }


         }else if(act==4) {
            int pk1;
            while(true) {
               
               System.out.println("변경할 학생의 번호를 입력하세요.");
               System.out.print("번호 입력>>> ");
               pk1=sc.nextInt();
               if(0<pk1 && pk1<30) { // 종료조건
                  break;
               }
               System.out.println("잘못된 범위입력입니다! 확인후 다시입력해보세요!");
            }

            // flag 변수
            boolean flag=true; // T이면 검색실패
            for(int i=0;i<std.size();i++) {
               if(pk1==std.get(i).getPk()) { // data.get(i) == 학생객체
                  flag=false; // F이면 검색성공
                  System.out.print("변경전정보 : ");
                  System.out.println(std.get(i));

                  System.out.println("   재시험처리중.......");
                  std.get(i).setNum(rd.nextInt(101));

                  System.out.print("변경후정보 : ");
                  System.out.println(std.get(i));
                  break; /// -> 디버깅표
               }
            }
            if(flag) {
               System.out.println("해당학생은 존재하지않습니다!");
            }
         

      }else if(act==5) {
         boolean flge=true;
         int pk1;
         while(true) {
            
            System.out.println("삭제할 학생의 번호를 입력하세요.");
            System.out.print("번호 입력>>> ");
            pk1=sc.nextInt();
            if(0<pk1 && pk1<30) { // 종료조건
               break;
            }
            System.out.println("잘못된 범위입력입니다! 확인후 다시입력해보세요!");
         }
         for(int i=0;i<std.size();i++) {
            if(pk1==std.get(i).getPk()) {
               System.out.println(std.get(i).getName()+"학생이 삭제되었습니다.");
               std.remove(i);
               flge=false;

               break;
            }
         }if(flge) {
            System.out.println("없는 학번 입니다.");
         }
      }else if(act==6) {
         int max=0 ;
         int tmp=0;
         System.out.println("1등인 학생!!");
         for(int i=0;i<std.size()-1;i++) {
            
               if(tmp<std.get(i).getNum()) {
                  max=i;
                  tmp=std.get(i).getNum();
               }

         }
         if(std.get(max).getNum()<std.get(std.size()-1).getNum()) {
            System.out.println(std.get(std.size()-1));
         }else {
            System.out.println(std.get(max));
         }

      }else if(act==7) {//종료
         System.out.println("종료!!!");
         break;      
      }else {
         System.out.println("잘못된입력");
      }
      }
   }
}

