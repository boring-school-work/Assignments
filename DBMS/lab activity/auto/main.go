package main

import (
	"crypto/sha512"
	"fmt"

	"golang.org/x/crypto/pbkdf2"
)

func hash(password string) []byte {
	pass := []byte(password)
	salt := []byte("GyetLG[:)xr#P=dh88")
	iterate_count := 10000
	klen := 32

	return pbkdf2.Key(pass, salt, iterate_count, klen, sha512.New)
}

func main() {
	passKeys := []string{
		"password",
		"water",
		"something",
		"another",
		"whosisthis",
		"iamtoolazy",
		"linuxislife",
		"wellwindowssolvessomething",
		"whatifthisworks",
		"spiderman",
		"someoneelse",
		"wellletssee",
	}

	var hashKeys []string

	for _, p := range passKeys {
		h := hash(p)
		var hashed string

		// recode each byte into utf8 string
		for _, v := range h {
			hashed += fmt.Sprintf("%02X", v)
		}

		hashKeys = append(hashKeys, hashed)
	}

	// display hashed keys
	for _, p := range hashKeys {
		fmt.Println(p)
	}
}
