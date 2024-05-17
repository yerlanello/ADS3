# ADS3

This project contains two custom implementations of data structures in Java: a Binary Search Tree (BST) and a Hash Table. 

## Table of Contents

- [BinarySearchTree](#binarysearchtree)
  - [Features](#features)
  - [Usage](#usage)
  - [Example](#example)
- [CustomHashTable](#customhashtable)
  - [Features](#features-1)
  - [Usage](#usage-1)
  - [Example](#example-1)
  - [Running the Hash Table Example](#running-the-hash-table-example)

## BinarySearchTree

The `BinarySearchTree` class is a generic implementation of a binary search tree (BST) where each node contains a key-value pair. The keys must be comparable to maintain the binary search property.

### Features

- **Insertion**: Adds a new key-value pair to the BST.
- **Retrieval**: Fetches the value associated with a given key.
- **Deletion**: Removes the node with the specified key from the BST.
- **Iteration**: Provides an iterator to traverse the tree in in-order.
- **Size**: Returns the number of elements in the BST.

### Usage

Class Declaration:
- `public class BinarySearchTree<K extends Comparable<K>, V>`

Methods:
- `void put(K key, V val)`: Inserts a key-value pair into the BST. If the key already exists, its value is updated.
- `V get(K key)`: Retrieves the value associated with the specified key. Returns `null` if the key is not found.
- `void delete(K key)`: Deletes the node with the specified key from the BST.
- `Iterator<Map.Entry<K, V>> iterator()`: Returns an iterator to traverse the BST in in-order.
- `int size()`: Returns the number of elements in the BST.

### Example

- Create a `BinarySearchTree` instance.
- Insert key-value pairs.
- Retrieve values by key.
- Delete nodes by key.
- Iterate over the BST.
- Get the size of the BST.

## CustomHashTable

The `CustomHashTable` class is a generic hash table implementation using separate chaining for collision resolution.

### Features

- **Insertion**: Adds a new key-value pair to the hash table.
- **Retrieval**: Fetches the value associated with a given key.
- **Deletion**: Removes the key-value pair with the specified key.
- **Contains**: Checks if a key is present in the hash table.
- **Key Retrieval**: Finds a key associated with a given value.
- **Bucket Sizes**: Returns the sizes of the buckets in the hash table.

### Usage

Class Declaration:
- `class CustomHashTable<K, V>`

Methods:
- `void insert(K key, V value)`: Inserts a key-value pair into the hash table. If the key already exists, its value is updated.
- `V retrieve(K key)`: Retrieves the value associated with the specified key. Returns `null` if the key is not found.
- `V erase(K key)`: Deletes the key-value pair with the specified key from the hash table. Returns the value associated with the key before deletion.
- `boolean contains(K key)`: Checks if the specified key exists in the hash table.
- `K getKey(V value)`: Finds a key associated with the given value. Returns `null` if the value is not found.
- `int[] getBucketSizes()`: Returns an array representing the sizes of the buckets in the hash table.

### Example

- Create a `CustomHashTable` instance.
- Insert key-value pairs.
- Retrieve values by key.
- Delete key-value pairs by key.
- Check if a key exists in the hash table.
- Retrieve a key by value.
- Get the sizes of the buckets in the hash table.

### Running the Hash Table Example

To test the hash table with a large number of entries and print the sizes of the buckets, you can run the `main` method provided in the class. This will insert 10,000 random key-value pairs into the hash table and print the sizes of each bucket, providing an insight into the distribution of the elements across the buckets.
