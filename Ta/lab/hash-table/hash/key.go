package hash

type Key interface {
	Hashcode() int
	Equals(key any) bool
}
