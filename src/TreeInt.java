public class TreeInt 
	{
		public TreeInt() { t=null; }
		public boolean add(int x)
		 {
			 Node p = t, pp=null;
			 boolean xIsLeft=true, xRetVal=true;
			 while (p!=null)
			   {if (x<p.getElement())
				  {pp = p;
				   p=p.getLeft();
				   xIsLeft = true;
				  }
			    else if (x>p.getElement())
				  {pp = p;
			       p=p.getRight();
				   xIsLeft = false;
				  }	
			    else // x=p.getElement()
			      {xRetVal = false;
			       break;
			      }
			   }
			 if (xRetVal)
			   {p = new Node(x);
			    if (pp==null)
			      t = p;
			    else
			      if (xIsLeft)
				    pp.setLeft(p);
			      else
				    pp.setRight(p);
			   }
			 return xRetVal;
		 }
		static private boolean isLeaf(Node p)
		 {
			 return p.getLeft()==null && p.getRight()==null;
		 }
		//-------------------------------------------------------------------
		static private boolean isOneSon(Node p)
		 {
			 if (p.getLeft()==null)
			   return p.getRight()!=null;
			 else // p.getLeft()!=null 
			   if (p.getRight()==null)
			     return true;
			   else
				 return false;
			   	 
		 }
		//-------------------------------------------------------------------
		//���������� true, ���� p ����� �� ����� ������ ����
		public boolean isLE1Son(Node p)
		   {
			 if (p.getLeft()==null)
			   return true;
			 else  // p.getLeft()!=null
			   return p.getRight()==null;
		   }
		//-------------------------------------------------------------------
		//������� ���� p (p ����� �� ����� ������ ����)
		public void deleteLE1Son(Node p, Node pPrev, boolean isLeft)
		  {
		   Node pSub;
		   if (p.getLeft()==null)
		     pSub = p.getRight();
		   else
		     pSub = p.getLeft();
		   if (isLeft)
		     pPrev.setLeft(pSub);
		   else
		     pPrev.setRight(pSub);
		  }
		
		//-------------------------------------------------------------------
		public boolean delete(int x)
		  {
		   Pair xpr = find(x);
		   if (xpr.rCurr==null)
			 return false;
		   if (xpr.rPrev==null && isLE1Son(xpr.rCurr))
		     {
			  t = xpr.rCurr.getLeft()==null ? xpr.rCurr.getRight(): xpr.rCurr.getLeft();    
		     }
		   else if (isLE1Son(xpr.rCurr))   // xpr.rPrev != null
			 {System.out.println("deleteLE1Son");
			  deleteLE1Son(xpr.rCurr,xpr.rPrev,xpr.isLeft);	
			 }
		   else // ��� ����
		     {
			  Node p  = xpr.rCurr.getLeft();
			  Node pp = xpr.rCurr;
			  while (p.getRight()!=null)
			    {pp = p; 
			     p = p.getRight();	
			    }
			  xpr.rCurr.setElement(p.getElement());
			  // ������� ���� p
			  deleteLE1Son(p,pp,pp==xpr.rCurr);
		     }
			 
		   return true;
		  }
		//-------------------------------------------------------------------
		
		public  Pair find(int x)
		  {
			 Node p = t, pp=null;
			 boolean xIsLeft=true;
			 while (p!=null)
			   {if (x<p.getElement())
				  {pp = p;
				   p=p.getLeft();
				   xIsLeft=true;
				  }
			    else if (x>p.getElement())
				  {pp = p;
			       p=p.getRight();
			       xIsLeft=false;
				  }	
			    else // x==p.getElement()
			       break;
			   }
			 return new Pair(p,pp,xIsLeft);
		  }
		//-------------------------------------------------------------------
		// ����� ������������ ���������, � ������� �� ������ ����������� �������
	    // ������� ����� ��� ����
		//-------------------------------------------------------------------
		
		public Node maxSub2Tree()
		  {
			OutPrm xPrm = new OutPrm();  // class KjvOutPrm { KjvNode maxTree;   int v; }
			maxSub2Tree(t,xPrm);
			return xPrm.maxTree;
		  }
		//-------------------------------------------------------------------

		public void maxSub2Tree(Node tr, OutPrm oPrm)
		  {
		   if (tr==null)
		     { oPrm.v = 0; oPrm.maxTree = null; }
		   else if (isLeaf(tr))
		     {oPrm.v = 1; 
		      oPrm.maxTree = tr;
		     }
		   else // ��� �� ���� � �� ������ ������
		     {OutPrm lPrm = new OutPrm();
		      OutPrm rPrm = new OutPrm();
			  maxSub2Tree(tr.getLeft(),lPrm); 
			  maxSub2Tree(tr.getRight(),rPrm);
			  oPrm.v = Math.min(lPrm.v,rPrm.v);
			  if (oPrm.v==1)
			    oPrm.maxTree = tr;
			  else if (lPrm.maxTree==null)
			    {// maxTree �������� �� ������� ���������
				 oPrm.maxTree = rPrm.maxTree;
			    }
			  else if (rPrm.maxTree==null)
			    {// maxTree �������� �� ������ ���������
			     oPrm.maxTree = lPrm.maxTree;	  
			    }
			  else  // ����� � ������ ���������� �� ������
				if (isLeaf(lPrm.maxTree))
			      oPrm.maxTree = rPrm.maxTree;
			    else
			      oPrm.maxTree = lPrm.maxTree;  				 
		     }			 
		  }
		//-------------------------------------------------------------------
		
		public void PostOrder()
		  {
		   PostOrder(t);
		  }
		//-------------------------------------------------------------------
		
		private void PostOrder(Node t)
		  {if (t==null)
			 ;
		   else 
		     {
		      PostOrder(t.getLeft());
		      PostOrder(t.getRight());
		      System.out.print(t.getElement()+" ");
		     }
		  }
		//private KjvNode t;
		public Node t;
	
	}
	//------------------------------------------------------------------------------

class Pair
  {
   public Pair(Node aCurr, Node aPrev) { this(aCurr, aPrev, true); }
   public Pair(Node aCurr, Node aPrev, boolean isLeft) 
		  { rCurr = aCurr; rPrev = aPrev; this.isLeft = isLeft;}
	
   Node rCurr;
   Node rPrev;
   boolean isLeft;
  }
//------------------------------------------------------------------------------

class OutPrm
  {
   Node maxTree;
	   int v;
  }