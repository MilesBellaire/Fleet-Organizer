
/**
 * Defines a class for reporting Heap exceptions and an interface that provides
 * methods for a heap
 * @author William Duncan
 * <pre>
 * File: HeapAPI
 * Date: 99-99-9999
 * CSC 3102 Programming Project # 1
 * Instructor: Dr. Duncan 
 *
 * DO NOT REMOVE THIS NOTICE (GNU GPL V2):
 * Contact Information: duncanw@lsu.edu
 * Copyright (c) 2021 William E. Duncan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>
 * </pre>
 */

/**
 * This class reports Heap exceptions.
 */
class HeapException extends Exception 
{
    /**
     * Creates a new instance of <code>HeapException</code> without detail
     * message.
     */
    public HeapException() { }

    /**
     * Constructs an instance of <code>HeapException</code> with the specified
     * detail message.
     * @param msg the detail message.
     */
    public HeapException(String msg) 
    {
        super(msg);
    }
}

/** 
 * Describes the basic operations of a heap
 * @author Duncan
 * @param <E>
 */
public interface HeapAPI<E extends Comparable<E>>
{
   /**
    * Determine whether the Heap is empty.
    * @return this method returns true if the heap is empty;
    * otherwise, it returns false if the heap contains at least one item.
    */
   boolean isEmpty();

   /**
    * Inserts an item into the Heap.
    * @param item the value to be inserted.
    */
   void insert(E item);

   /**
    * An exception is generated if this method is invoked
    * by an empty heap. The maximum/minimum value is removed
    * from the heap if the heap is not empty and its effective
    * size is reduced by 1.
    * @return the maximum (in the case of a maxheap) or the
    * minimum (in the case of a minheap) on the heap.
    * @throws HeapException when the heap is empty
    */
   E remove() throws HeapException;

   /**
    * An exception is generated if this method is invoked
    * by an empty heap
    * @return the maximum (in the case of a maxheap) or the
    * minimum (in the case of a minheap) on the heap.
    * @throws HeapException when the heap is empty
    */
   E peek() throws HeapException;


   /**
    * Gives the size of this heap
    * @return the size of the heap; the effective size of the
    * heap.
    */
   int size();
}
