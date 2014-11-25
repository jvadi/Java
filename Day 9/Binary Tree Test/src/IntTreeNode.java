
public class IntTreeNode {

	public int value;
	public IntTreeNode left;
	public IntTreeNode right;
	
	
	public IntTreeNode(){
		this.left = null;
		this.right = null;
	}
	
	public IntTreeNode(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	
	public void add(int newNumber){
		if (newNumber > this.value){
			if (right == null){
				this.right = new IntTreeNode(newNumber);
			}else{
				this.right.add(newNumber);
			}
		}else{
			if (left == null){
				this.left = new IntTreeNode(newNumber);
			}else{
				this.left.add(newNumber);
			}
		}
	}
	
	public boolean contains(int n){
		if (this.value == n){
			return true;
		}else if (n > this.value){
			if (this.right == null){
				return false;
			}else{
				return this.right.contains(n);
			}
		}else{
			if (this.left == null){
				return false;
			}else{
				return this.left.contains(n);
			}
		}
	}
	
	public int getMax(){
		if (this.right == null){
			return this.value;
		}else{
			return this.right.getMax();
		}
	}
	
	public int getMin(){
		if (this.left == null){
			return this.value;
		}else{
			return this.left.getMin();
		}
	}
	
	public String toStringComplete(){
		
		String result = "["+this.value+" ";
		
		if (this.left == null){
			result += "L[]";
		}else{
			result += "L["+this.left.toStringComplete();
		}
		
		if (this.right == null){
			result += "R[]";
		}else{
			result += "R["+this.right.toStringComplete();
		}
		
		result += "]";
		
		return result;
	}

	@Override
	public String toString(){
		String result = "["+this.value;
		
		if (this.left != null){
			result += this.left.toString();
		}
		if (this.right != null){
			result += this.right.toString();
		}
		
		result += "]";
		return result;
		
	}
	public int depth(){
		if (this.left == null && this.right == null){
			return 1;
		}else if (this.left == null){
			return this.right.depth()+1;
		}else if (this.right == null){
			return this.left.depth()+1;
		}else{
			return Integer.max(this.right.depth(), this.left.depth())+1;
		}
	}

	public boolean remove(int number){
		
		if (this.value == number){
			if (this.right != null){
				this.value = this.right.getMin();
				
				if (this.right.left == null){
					this.right = this.right.right;
					return true;
				}
				
				
				
				
	
				return this.right.remove(this.right.getMin());
			}else if (this.left != null){
				this.value = this.left.getMax();
				return this.left.remove(this.left.getMax());
			}else{
				
			}
		} 
				
		//if not number remove number left or right depending on which side it will be
		
		return false;
	}
	
}
