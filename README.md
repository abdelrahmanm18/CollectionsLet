## CollectionsLet 1.0

CollectionsLet is my own implemenation of the Java Collections interface. The goal is to recreate the core interfaces and classes (like List, Set, Map, and Deque) and implement their most commonly used methods.

This project is designed for learning and practicing object-oriented design, data structure implementation.

## CollectionsLet Overview

The CollectionsLet interface defines common methods shared across all collection interfaces.

The CollectionsLet interface is extended by another four interfaces:

- List<E> 
- Set<E>
- Map<K, V>
- Deque<E> 

Each interface (List, Set, Map, and Deque) inherits from the base CollectionsLet interface.

Each interface is implemented by specific classes. For example, the List interface is implemented by LinkedList and ArrayList.

## Design Diagram:

<img width="1412" height="618" alt="image" src="https://github.com/user-attachments/assets/a05cea90-1a3a-485d-a675-14de76419f4e" />

---

## Implementation notes:

### Array List resizing:

When we should resize the list(the inner array)?

- We should resize up when the inner array's size is around 80%, 50% will be a waste of memory space as half of the inner array is still empty.

- We should resize down when the size of the inner% array is less the 25% of the capacity but why 25% not 50%? 
	- 25% creates a buffer zone to avoid resizing up when its not needed.
	- with 50%, add/remove operations could trigger constant resizing.

Example:
Capacity: 100, Size: 25 → Resize down to capacity 50 (25% ratio) ✅✅
Now you'd need to grow to size 40 (80% of 50) before resizing up again

Capacity: 100, Size: 50 → Resize down to capacity 50 (50% ratio)❌❌
Now you have to resize up again as the size > 80% of 50


How we should resize and why?

- Resize up the inner array with multiplicative factor (1.5x or 2x) when the array is close to be full and resize down the inner but why?
- Growing the array by multiplicative factor is much faster than additive factor.
- Resize down by halving the array why?
---
