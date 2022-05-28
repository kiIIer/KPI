package hash

type Entry[K Key, V any] struct {
	key   K
	value V
}

func NewEntry[K Key, V any](key K, value V) *Entry[K, V] {
	return &Entry[K, V]{
		key:   key,
		value: value,
	}
}

func (entry *Entry[K, V]) Key() K {
	return entry.key
}

func (entry *Entry[K, V]) Value() V {
	return entry.value
}
