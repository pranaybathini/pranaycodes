/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */


class GfG
{
    Node flatten(Node a)
    {
	// Your code here
	    if(a == null || a.next == null){
	        return a;
	    }
	    a.next = flatten(a.next);
	 return flatten(a,a.next);

    }
    
    Node flatten(Node a, Node b){
        if(a == null){
            return b;
        }
        
        if(b == null){
            return a;
        }
        
        
        Node result = new Node(-1);
        Node temp = result;
        
        while(a!=null && b!=null){
            if(a.data < b.data){
                temp.bottom = a;
                a = a.bottom;
                temp = temp.bottom;
                
            }else{
                 temp.bottom = b;
                b = b.bottom;
                temp = temp.bottom;
            }
        }
        
        while(a!=null){
            temp.bottom = a;
            a = a.bottom;
            temp = temp.bottom;
        }
        
        while(b!=null){
            temp.bottom = b;
            b= b.bottom;
            temp = temp.bottom;
        }
        

        return result.bottom;
       
       
    }
}
