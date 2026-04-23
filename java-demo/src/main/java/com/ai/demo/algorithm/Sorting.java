package com.ai.demo.algorithm;

/**
 * 排序算法实现
 * 
 * 知识点：
 * - 时间复杂度 O(n log n) vs O(n²)
 * - 空间复杂度
 * - 稳定性
 * - 分治思想
 * 
 * 对应面试题：
 * - 快速排序的最坏情况？
 * - 归并排序为什么稳定？
 * - 堆排序的时间复杂度？
 */
public class Sorting {
    
    /**
     * 快速排序
     * 
     * 时间复杂度：平均 O(n log n)，最坏 O(n²)
     * 空间复杂度：O(log n) 递归栈
     * 稳定性：不稳定
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * 分区操作
     * 选择最后一个元素作为 pivot
     * 将小于 pivot 的元素移到左边，大于的移到右边
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;  // 小于 pivot 的区域的边界
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    /**
     * 归并排序
     * 
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }
    
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // 分治
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }
    
    /**
     * 合并两个有序数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;      // 左数组指针
        int j = mid + 1;   // 右数组指针
        int k = 0;         // 临时数组指针
        
        // 比较并合并
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        // 处理剩余元素
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        // 复制回原数组
        for (i = 0; i < k; i++) {
            arr[left + i] = temp[i];
        }
    }
    
    /**
     * 堆排序
     * 
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        
        // 构建大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // 逐个提取元素
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);        // 将堆顶移到末尾
            heapify(arr, i, 0);     // 重新调整堆
        }
    }
    
    /**
     * 调整堆
     * 
     * @param arr 数组
     * @param n 堆大小
     * @param i 当前节点索引
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        // 找出最大的节点
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // 如果最大值不是当前节点，交换并递归
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    
    /**
     * 冒泡排序
     * 
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            
            // 如果没有交换，说明已有序
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * 选择排序
     * 
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            // 找最小值
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // 交换
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }
    
    /**
     * 交换元素
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
