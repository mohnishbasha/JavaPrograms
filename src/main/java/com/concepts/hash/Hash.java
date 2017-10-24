/**

 Hash:  A good hash function satisfies that: each key is equally likely to hash to any of the n memory slots
 independently of where any other key has hashed to.

 Your hash function may return the same memory location for two different inputs, in this case you will have a collision
 you if you are implementing your own hash table you have to take care of this maybe using a linked list or other
 techniques.

 Hashing is a mechanism to get a memory location.
 hash(Rachel) = 10
 Lets say if u have an array of a[100]
 then a[10] = "Rachel" as per the hash above


 - Hashing means generating a (hopefully) unique number that represents a value.
 - Different types of values (Integer, String, etc) use different algorithms to compute a hashcode.
 - HashMap and HashTable are maps; they are a collection of unqiue keys, each of which is associated with a value.
 - Java doesn't have a HashList class. A HashSet is a set of unique values.
 - Getting an item from a hashtable is constant-time with regard to the size of the table.
 - Computing a hash is not necessarily constant-time with regard to the value being hashed.
 - For example, computing the hash of a string involves iterating the string, and isn't constant-time with regard to the size of the string.
 - These are things that people ought to know.

 As per manachers:
 https://en.wikipedia.org/wiki/Hash_function
 A hash function is any function that can be used to map data of arbitrary size to data of fixed size.
 The values returned by a hash function are called hash values, hash codes, hash sums, or simply hashes.


 Uses:
 - Hashtable
 - Caches
 - BloomFilter
 - Finding duplicate records
 - Finding similar records
 - Find similar substring
 - Geometric hashing
 - standard uses of hashes in crytography
 https://en.wikipedia.org/wiki/Hash_function

 Various Hash Algorithms:
 - Trivial Hash function
 - Perfect Hashing
 - Minimal Perfect Hashing
 - Hashing uniformly distributed data
 - Hashing data with other distribution
 - Hashing variable lenth data

 The idea of hashing is to distribute the entries (key/value pairs) across an array of buckets. Given a key, the algorithm computes an index that suggests where the entry can be found:
 - index = f(key, array_size)

 Often this is done in two steps:
 - hash = hashfunc(key)
 - index = hash % array_size

 */