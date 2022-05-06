public class MinHeap{
int size;
Int maxSize;
Int front;
Int heap[];

Public MinHeap(int maxSize){
	maxSize = maxSize;
	Size = 0;
            Heap = new int[maxSize+1];
 	Heap[0] = Integer.INT_MIN;
}	

Int parent(int pos){return pos/2;}
Int left(int pos){return 2*pos;}
Int right(int pos){return 2*pos+1;}
Boolean isLeaf(int pos){
	if(pos > size/2 && pos <= size) return true;
Return false;
}

Int swap(fp, sp){
	Int temp = heap[fp];
	Heap[fp] = heap[sp];
	Heap[sp] = temp;
}

//logn
Void insert(int elt){
	if(size >= maxSize)return;
	Heap[++size] = elt;
	Int curr = size;
	while(heap[curr] < heap[parent(curr)]{
	swap(curr,parent(curr));
	Curr = parent(curr);
}
}

//logn
Int extractMin(){
	Int pop = heap[front];
	Heap[front] = heap[size–];
	minHeapify(front);
	return pop;
}


// logn
Void minHeapify(int pos){
	if(!isLeaf(pos)){
		Int left = left(pos);
		Int right = right(pos);
		if(heap[pos] > heap[left] || heap[pos] > heap[right]){
			if(heap[left] < heap[right]){
				swap(pos,left);
				minHeapify(left);
}else{
	swap(pos,right);
	minHeapify(right);
}
		}
  	}	
}

//O(1) TC
Int getMin(){
Return heap[front];
}
}

