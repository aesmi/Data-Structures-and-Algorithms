// Static arrays are given continuous chunks of memory when a new instance is created
// All memory addresses are adjacent to each other

// When are static arrays used?
// 1. Storing and accessing sequential data
// 2. Temporarily storing objects
// 3. Used by IO routines as buffers
// 4. Lookup tables and inverse lookup tables
// 5. Can be used to return multiple values from a function if you're using a language that only allows one return value at a time
// 6. Used in dynamic programming to cache answers to subproblems

// Complexity
//             Static Array , Dynamic Array
// Access          O(1)            O(1)
// Search          O(n)            O(n)
// Insertion       N/A fixed size  O(n)
// Appending       N/A fixed size  O(1)
// Deletion        N/A fixed size  O(n)

// For static arrays: insertion, appending, and deletion isn't possible due to the inabiltiy to expand the array to accomodate new entries
// Size of array is fixed when the array object is initialized

// When creating a dynamic array: We can initialize it to have a size which is dynamically increased when we need additional space

package Arrays;

@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T> {

  private T[] arr;
  private int len = 0; // length user thinks array is
  private int capacity = 0; // Actual array size

  public void DynamicArray(int capacity) {
    if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
    this.capacity = capacity;
    arr = (T[]) new Object[capacity];
  }

  public int size() {
    return len;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public T get(int index) {
    return arr[index];
  }

  public void set(int index, T elem) {
    arr[index] = elem;
  }

  public void clear() {
    // systematically clears array by replacing each value with a null type
    for (int i = 0; i < len; i++) arr[i] = null;
    len = 0;
  }

  public void add(T elem) {

    // Time to resize!
    if (len + 1 >= capacity) {
      if (capacity == 0) capacity = 1;
      else capacity *= 2; // double the size
      T[] new_arr = (T[]) new Object[capacity];
      for (int i = 0; i < len; i++) new_arr[i] = arr[i];
      arr = new_arr; // arr has extra nulls padded
    }

    arr[len++] = elem;
  }

  // Removes an element at the specified index in this array.
  public T removeAt(int rm_index) {
    if (rm_index >= len || rm_index < 0) throw new IndexOutOfBoundsException();
    T data = arr[rm_index];
    T[] new_arr = (T[]) new Object[len - 1];
    for (int i = 0, j = 0; i < len; i++, j++)
      if (i == rm_index) j--; // Skip over rm_index by fixing j temporarily
      else new_arr[j] = arr[i];
    arr = new_arr;
    capacity = --len;
    return data;
  }

  public boolean remove(Object obj) {
    int index = indexOf(obj);
    if (index == -1) return false;
    removeAt(index);
    return true;
  }

  public int indexOf(Object obj) {
    for (int i = 0; i < len; i++) {
      if (obj == null) {
        if (arr[i] == null) return i;
      } else {
        if (obj.equals(arr[i])) return i;
      }
    }
    return -1;
  }

  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }

  // Iterator is still fast but not as fast as iterative for loop
  @Override
  public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < len;
      }

      @Override
      public T next() {
        return arr[index++];
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

  @Override
  public String toString() {
    if (len == 0) return "[]";
    else {
      StringBuilder sb = new StringBuilder(len).append("[");
      for (int i = 0; i < len - 1; i++) sb.append(arr[i] + ", ");
      return sb.append(arr[len - 1] + "]").toString();
    }
  }
}