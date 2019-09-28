package com.company;




/**
 * Array
 * 自定义数组
 * @author heng
 * @date 2019/9/24
 **/
public class Array<E> {

    /**
     * 存储的data
     */
    private  E[] data;

    /**
     * 描述data中有效的数量
     */
    private int size;

    /**
     * 无参构造
     */
    public Array(){
        this(10);
    }
    /**
     * 构造函数 传入 capacaity构造Array的容量
     * @param capacaity
     */
    public Array(int capacaity){
        data = (E[])new Object[capacaity];
        size = 0;
    }

    /**
     * 返回数组中容量大小
     * @return
     */
    public int getCapacaity() {
        return data.length;
    }

    /**
     * 返回容量size
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向最后一位添加数据
     * @param e
     */
    public void addLast(E e){
        /*if (size == data.length){
            throw  new IllegalArgumentException("AddLast faied. Array is null");
        }
        data[size] = e;
        size ++;*/
        add(size,e);
    }
    /**
     * 向第一一位添加数据
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }
    /**
     * 在index插入一个新的元素e
     * @param index
     * @param e
     */
    public void add(int index,E e){

        if (index < 0 || index > size){
            throw  new IllegalArgumentException("Add faied. Array Require index>= 0 and index <= size");
        }

        if (size == data.length){
            //这里进行空间扩容 扩容2倍
            this.resize(2 * data.length);
           // throw  new IllegalArgumentException("Add faied. Array is null");
        }
        for(int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }



    /**
     * 通过下标获取元素
     * @param index
     * @return
     */
    E get(int index){
        if(index <0 || index >= size){
            throw  new IllegalArgumentException("Get faied. Array is null");
        }
        return  data[index];
    }

    /**
     * 根据下标更新
     * @param index
     * @return
     */
    void set(int index,E e){
        if(index <0 || index >= size){
            throw  new IllegalArgumentException("Get faied. Array is null");
        }
          data[index] = e;
    }

    /**
     * 是否存在该值
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
          if (data[i].equals(e) ){
              return  true;
          }
        }
        return  false;
    }

    /**
     * 返回传入的值的索引如果没有返回-1
     * 不考虑多个值索引
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return  i;
            }
        }
        return  -1;
    }
    /**
     * 返回传入的值的在数组中存在多少个 没有返回0
     * 不考虑多个值索引
     * @param e
     * @return
     */
    public int findCout(E e){
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                count ++;
            }
        }
        return  count;
    }


    /**
     * 根据下标删除
     */
    /**
     * 根据index索引删除 并返回删除的索引值
     * @param index
     * @param
     */
    public E remove(int index){
        if (index < 0 || index > size){
            throw  new IllegalArgumentException("Remove faied. Array Require index>= 0 and index <= size");
        }
        E ret = data[index];
        for(int i = index+1; i < index; i++) {
            data[i-1] = data[i];
        }

        size --;//注意size --后还存在一个值只不过用户访问不到这个值
        data[size] = null;//让jvm回收机制回收 不是必填的 loitering objects != memory leak
        /**
         * 进行空间减少  lazy 减少 防止复杂度震荡  size = 4/1的时候减少空间
         */
        if (size == data.length / 4 &&  data.length / 2 != 0){
            resize(data.length / 2);
        }
        return  ret;
    }

    /**
     * 删除数组中第一个元素
     * @param
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个下标
     * @param
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 如果存在该值则删除 删除单个
     * @param e
     */
    public void romoveElement(E e){
      int index = find(e);
      if (index != -1){
          remove(index);
      }
    }

    /**
     * 如果存在该值则删除 删除数组中全部e值
     * @param e
     */
    public void romoveElementAll(E e){
        System.err.println(data.length);
        E newData[] =(E[])new Object[data.length];
        int index = 0;
        for(int i = 0; i < size; i++) {
           if (!data[i].equals(e)){
               newData[index] = data[i];
               index ++;
           }
        }
        size = index;
        data = newData;
        /**
         * 进行空间减少 lazy 减少 防止复杂度震荡  size < 4/1的时候减少空间
         */
        if (size < data.length / 4 &&  data.length / 2 != 0){
            resize(data.length / 2);
        }
    }
    /**
     * toString 方法
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array: size = %d , capacaity = %d\n",size,data.length));
        builder.append("[ ");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size-1){
                builder.append(" , ");
            }
        }
        builder.append(" ]");
        return builder.toString();
    }
    /**
     * 扩容空间
     * @param  //扩容的数量
     */
    private void resize(int newCapacaity){
        E newData[] =(E[])new Object[newCapacaity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data =  newData;
    }
}
