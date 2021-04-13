/*
 * Copyright (c) 2021. Increff
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.nextscm.commons.lang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Creates a list of lists (buckets) for elements with a limit on bucket size
 */
public class Interner<T> {

    private List<List<T>> buckets = new ArrayList<>();
    int numBuckets;

    public Interner() {
        this(256, 16);
    }

    /**
     * Create an Internet object with capacity/load buckets
     * @param capacity Total capacity to be accommodated
     * @param load Max load per bucket
     */
    public Interner(int capacity, int load) {
        numBuckets = capacity / load;
        buckets = new ArrayList<>(numBuckets);
        //as getBuckets will fail because size will be zero giving index out ot bounds
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>(load));
        }
    }

    /**
     * Insert an element into a bucket based on Object hash code
     * If object already exists, returns it
     * @param t Object to be inserted/retrieved
     * @return The object that was inserted/found
     */
    public T intern(T t) {
        if (t == null) {
            return t;
        }
        int index = getBucketIndex(t);
        List<T> bucket = getBucket(index);
        // Find existing object
        T e = search(bucket, t);
        return e;
    }

    /**
     * Returns the bucket index for an object based on object's hash code
     * @param t Object whose bucket index is to be searched
     * @return Bucket index
     */
    private int getBucketIndex(T t) {
        int hash = t.hashCode();
        int index = hash & (numBuckets - 1);
        return index;
    }

    /**
     * Fetch bucket stored at a given index in Interner object
     * If bucket exists then return it, else create and return new bucket
     * @param index Index to search
     * @return Final List of buckets at specified index
     */
    private List<T> getBucket(int index) {
        List<T> bucket = buckets.get(index);
        if (bucket == null) {
            bucket = new LinkedList<T>();
            buckets.add(index, bucket);
        }
        return bucket;
    }

    /**
     * Search for specified object in provided bucket
     * If object exists then return it, else create and return new object
     * @param bucket Bucket to search
     * @return Object that was searched
     */
    private T search(List<T> bucket, T t) {
        for (T value : bucket) {
            if (value.equals(t)) {
                return t;
            }
        }
        bucket.add(t);
        return t;
    }

}
