public class Stack {

        Node first;

        public boolean hasPop() {
                if (first == null) {
			return false;
		}

		return true;
        }

        public void push(int value) {
		Node newNode = new Node(value);
		newNode.setNext(first);
		first = newNode;
        }

        public int pop() {
		if (!hasPop()){
			throw new IllegalStateException("Stack kosong!");
		}
		int value = first.getValue();
                first = first.getNext();
                return value;
        }

	public void swap (int index1, int index2) {
		if (index1 == index2) return;

		if (index1 > index2) {
			int temp = index1;
			index1 = (index2);
			index2 = temp;
		}

		try {
			if (index1 < 0) {
				throw new IndexOutOfBoundsException("Tidak ada index negatif!");
		}
				Node node1 = getNode(index1);
				Node node2 = getNode(index2);

				if (node2 == null) {
					throw new IndexOutOfBoundsException("Index ke-" + index2 + " tidak ditemukan!");

				}

			Node tempPrev1;
			if (node1 == first) {
				tempPrev1 = null;
			} else {
				tempPrev1 = getNode(index1-1);
			}

			Node tempNext1 = node1.getNext();

			Node tempNext2 = node2.getNext();
			Node tempPrev2 = getNode(index2-1);
			if (tempNext1 == node2) {
				node1.setNext(tempNext2);
				node2.setNext(node1);
			
				if (tempPrev1 != null) {
					tempPrev1.setNext(node2);
				} else {
					first = node2;
				}
				return;
			}
			node2.setNext(tempNext1);

			tempPrev2.setNext(node1);

			node1.setNext(tempNext2);

			if (tempPrev1 != null) {
				tempPrev1.setNext(node2);
			} else {
				first = node2;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private Node getNode(int index) {
		Node target = first;                              for(int i=0; i < index; i++){                             target = target.getNext();
		}                                                 return target;
	}

	public int peek (int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Tidak ada index negatif!");
		}
		Node target = first;
		for(int i=0; i < index; i++){
			target = target.getNext();
			if (target == null) {
				throw new IndexOutOfBoundsException("Value dengan index ke-" + index +" tidak ditemukan");
			}
		}
		return target.getValue();
		
	}
}
