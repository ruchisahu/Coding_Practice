package Chap_11;

//public class ChainingHashTable<K,V> implements HashTable<K,V> {
	public class ChainingHashTable<K,V> {
	private HashTableNode<K,V>[] table;
	private int capacity;
	int size;
	 public ChainingHashTable(int capacity) {
	        this.capacity=capacity;
	        table= new HashTableNode[capacity];
	        size = 0;
	    }
	 
	private static class HashTableNode<K,V> {

        private final K index;
        private final V value;
        private HashTableNode<K,V> previous;
        private HashTableNode<K,V> next;

        public HashTableNode(K index, V value) {
            this.index = index;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getIndex() {
            return index;
        }

        public HashTableNode<K,V> getPrevious() {
            return previous;
        }

        public void setPrevious(HashTableNode<K,V> previous) {
            this.previous = previous;
        }

        public HashTableNode<K,V> getNext() {
            return next;
        }

        public void setNext(HashTableNode<K,V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(value) + (next == null ? "" : "," + next);
        }
        

    }


	// hash function for keys - returns value between 0 and m-1
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }
	

	public V get(K index) {
		int hash=hash(index);
		final HashTableNode<K,V> item = find(index, hash);
        return item == null ? null : item.getValue();
		
		
	}

	public void put(K index, V item) {
		HashTableNode<K,V> node=new HashTableNode<K,V>(index,item);
		int hash=hash(index);
		if(table[hash]==null) {
			table[hash]=node;
			size++;
		}
		else {
			final HashTableNode<K,V> found = find(index, hash);
			if (found != null) {
                if (found.getPrevious() != null) {
                    found.getPrevious().setNext(node);
                } else {
                    table[hash] = node;
                }
                if (found.getNext() != null) {
                    found.getNext().setPrevious(node);
                }
                found.setPrevious(null);
                found.setNext(null);
                return;
            }
            node.setNext(table[hash]);
            table[hash].setPrevious(node);
            table[hash] = node;
            size ++;
        }
		}
			
		
		
	
	 private HashTableNode<K,V> find(K index, int hash) {
	        if (table[hash] == null) {
	            return null;
	        }
	        HashTableNode<K,V> cursor = table[hash];
	        while (cursor != null) {
	            if (cursor.getIndex() == index) {
	                return cursor;
	            }
	            cursor = cursor.getNext();
	        }
	        return null;
	    }

	public void delete(K index) {
		int hash=hash(index);
	        final HashTableNode<K,V> item = find(index, hash);
	        if (item != null) {
	            if (item.getNext() == null && item.getPrevious() == null) {
	                table[hash] = null;
	                size --;
	                return;
	            }
	            if (item.getNext() != null) {
	                item.getNext().setPrevious(item.getPrevious());
	            }
	            if (item.getPrevious() != null) {
	                item.getPrevious().setNext(item.getNext());
	            }
	            item.setPrevious(null);
	            item.setNext(null);
	            size --;
	        }
		
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return getSize()==0;
	}

	public int getCapacity() {
		// TODO Auto-generated method stub
		return capacity;
	}
	
	public static void main(String[] args) {
		ChainingHashTable<String,Integer> map=new ChainingHashTable<String, Integer>(4);
		map.put("a",1);
		map.put("b", 2);
		map.put("c", 2);
		map.put("d", 4);
		System.out.println(map.get("d"));
		

	}
}


	