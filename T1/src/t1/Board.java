package t1;

import java.util.*;


class Student{
   private int pk;//�й�
    private String name;//�̸�
    private int num;//���� 

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
      return "[�й�" + pk + " �̸�:" + name + " ����:" + num + "]";
   }


}








public class Board {
   public static void main(String[] args) {
      Random rd=new Random();
      Scanner sc=new Scanner(System.in);
      ArrayList<Student> std=new ArrayList<Student>();
      int pk=10;
      std.add(new Student(pk++,"��",rd.nextInt(101)));
      std.add(new Student(pk++,"��",rd.nextInt(101)));
      std.add(new Student(pk++,"��",rd.nextInt(101)));
      std.add(new Student(pk++,"��",rd.nextInt(101)));
      std.add(new Student(pk++,"��",rd.nextInt(101)));
      while(true) {
         System.out.println("===ȭ��===");
         System.out.println("1. �⼮�� ���");
         System.out.println("2. �л� ���");
         System.out.println("3. �л� ���� ���");
         System.out.println("4. �л����� ����");
         System.out.println("5. �л� ����");
         System.out.println("6. 1���л� �̸� ���");
         System.out.println("7. ���α׷� ����");
         System.out.println("========");
         System.out.println("");

         int act=sc.nextInt();


         if(act==1) {
        	   if(std.size()==0) {
                   System.out.println("�л��� 0���Դϴ�!");
                   continue;
                }

            Iterator itr=std.iterator();
            while(itr.hasNext()) {
               System.out.println(itr.next()); 
            }

         }else if(act==2) {
            System.out.print("�̸��� �Է����ּ���>>");
            String name=sc.next();
            System.out.println("������ �Է��Ͻðڽ��ϱ�? Y/N");
            String YN=sc.next();
            YN=YN.toUpperCase();
            if(YN.equals("N")) {
               std.add(new Student( pk++ ,name));
            }else {
               std.add(new Student(pk++,name,rd.nextInt(101)));
            }
            System.out.println("��ϵǾ����ϴ�.");


         }else if(act==3) {
            boolean flge=true;
            int pk1;
            while(true) {
               
               System.out.println("����� �л��� ��ȣ�� �Է��ϼ���.");
               System.out.print("��ȣ �Է�>>> ");
               pk1=sc.nextInt();
               if(0<pk1 && pk1<30) { // ��������
                  break;
               }
               System.out.println("�߸��� �����Է��Դϴ�! Ȯ���� �ٽ��Է��غ�����!");
            }
            
            for(int i=0;i<std.size();i++) {
               if(pk1==std.get(i).getPk()) {
                  System.out.println(std.get(i));
                  System.out.println("��¿Ϸ�!!");
                  flge=false;
                  break;
               }
            }
            if(flge) {
               System.out.println("���� �й� �Դϴ�.");
            }


         }else if(act==4) {
            int pk1;
            while(true) {
               
               System.out.println("������ �л��� ��ȣ�� �Է��ϼ���.");
               System.out.print("��ȣ �Է�>>> ");
               pk1=sc.nextInt();
               if(0<pk1 && pk1<30) { // ��������
                  break;
               }
               System.out.println("�߸��� �����Է��Դϴ�! Ȯ���� �ٽ��Է��غ�����!");
            }

            // flag ����
            boolean flag=true; // T�̸� �˻�����
            for(int i=0;i<std.size();i++) {
               if(pk1==std.get(i).getPk()) { // data.get(i) == �л���ü
                  flag=false; // F�̸� �˻�����
                  System.out.print("���������� : ");
                  System.out.println(std.get(i));

                  System.out.println("   �����ó����.......");
                  std.get(i).setNum(rd.nextInt(101));

                  System.out.print("���������� : ");
                  System.out.println(std.get(i));
                  break; /// -> �����ǥ
               }
            }
            if(flag) {
               System.out.println("�ش��л��� ���������ʽ��ϴ�!");
            }
         

      }else if(act==5) {
         boolean flge=true;
         int pk1;
         while(true) {
            
            System.out.println("������ �л��� ��ȣ�� �Է��ϼ���.");
            System.out.print("��ȣ �Է�>>> ");
            pk1=sc.nextInt();
            if(0<pk1 && pk1<30) { // ��������
               break;
            }
            System.out.println("�߸��� �����Է��Դϴ�! Ȯ���� �ٽ��Է��غ�����!");
         }
         for(int i=0;i<std.size();i++) {
            if(pk1==std.get(i).getPk()) {
               System.out.println(std.get(i).getName()+"�л��� �����Ǿ����ϴ�.");
               std.remove(i);
               flge=false;

               break;
            }
         }if(flge) {
            System.out.println("���� �й� �Դϴ�.");
         }
      }else if(act==6) {
         int max=0 ;
         int tmp=0;
         System.out.println("1���� �л�!!");
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

      }else if(act==7) {//����
         System.out.println("����!!!");
         break;      
      }else {
         System.out.println("�߸����Է�");
      }
      }
   }
}

