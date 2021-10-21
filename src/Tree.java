public class Tree {

	public static void main(String[] args) {
        TreeInt xTr = new TreeInt();
        xTr.add(20);
        xTr.add(15);
        xTr.add(10);
        xTr.add(24);
        xTr.add(22);
        xTr.add(30);
        xTr.add(25);
        xTr.add(21);
        xTr.add(5);
        xTr.add(12);
       
        xTr.PostOrder();
        System.out.println();

        Node nd = xTr.maxSub2Tree();
        System.out.println("maxTree="+nd.getElement());
        
        
	}
}
