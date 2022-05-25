package hash

type Table[K Key, V any] struct {
	loadFactor float64
	size       int
	capacity   int
	buckets    [][]*Entry[K, V]
}

type TableOption[K Key, V any] func(table *Table[K, V])

func withLoadFactor[K Key, V any](loadFactor float64) TableOption[K, V] {
	return func(table *Table[K, V]) {
		table.loadFactor = loadFactor
	}
}

func withCapacity[K Key, V any](capacity int) TableOption[K, V] {
	return func(table *Table[K, V]) {
		table.capacity = capacity
	}
}

func NewTable[K Key, V any](options ...TableOption[K, V]) *Table[K, V] {
	const (
		defaultLoadFactor = 0.75
		defaultCapacity   = 1 << 3
	)

	newTable := &Table[K, V]{
		loadFactor: defaultLoadFactor,
		capacity:   defaultCapacity,
	}

	for _, option := range options {
		option(newTable)
	}

	newTable.buckets = make([][]*Entry[K, V], newTable.capacity)

	return newTable
}

func (table *Table[K, V]) increaseCapacity() {
	entries := table.Slice()
	table.capacity <<= 1
	table.buckets = make([][]*Entry[K, V], table.capacity)
	for _, entry := range entries {
		bucketIndex := entry.key.Hashcode() % table.capacity
		table.putInBucket(entry, bucketIndex)
	}
}

func (table *Table[K, V]) Put(key K, value V) {
	if float64(table.size/table.capacity) > table.loadFactor {
		table.increaseCapacity()
	}
	toPut := NewEntry[K, V](key, value)
	hash := key.Hashcode()
	buketIndex := hash % table.capacity
	table.putInBucket(toPut, buketIndex)
}

func (table *Table[K, V]) putInBucket(toPut *Entry[K, V], bucketIndex int) {
	bucket := table.buckets[bucketIndex]
	index := -1
	for i, entry := range bucket {
		if entry == nil {
			index = i
			continue
		}
		if entry.key.Equals(toPut.key) {
			index = i
			table.size--
			break
		}
	}
	if index == -1 {
		table.buckets[bucketIndex] = append(bucket, toPut)
	} else {
		bucket[index] = toPut
	}
	table.size++
}

func (table *Table[K, V]) Get(key Key) *Entry[K, V] {
	hash := key.Hashcode()
	bucketIndex := hash % table.capacity
	bucket := table.buckets[bucketIndex]
	return table.getFromBucket(key, bucket)
}

func (table *Table[K, V]) getFromBucket(key Key, bucket []*Entry[K, V]) *Entry[K, V] {
	for _, entry := range bucket {
		if entry.Key().Equals(key) {
			return entry
		}
	}
	return nil
}

func (table *Table[K, V]) Delete(key Key) {
	hash := key.Hashcode()
	bucketIndex := hash % table.capacity
	table.deleteFromBucket(key, bucketIndex)
}

func (table *Table[K, V]) deleteFromBucket(key Key, bucketIndex int) {
	for i, entry := range table.buckets[bucketIndex] {
		if entry.key.Equals(key) {
			table.buckets[bucketIndex][i] = nil
			table.size--
			return
		}
	}
}

func (table *Table[K, V]) Slice() []*Entry[K, V] {
	var entries []*Entry[K, V]
	for _, bucket := range table.buckets {
		for _, entry := range bucket {
			if entry != nil {
				entries = append(entries, entry)
			}
		}
	}

	return entries
}
