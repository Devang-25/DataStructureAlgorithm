package main

import (
	"fmt"
	"strings"
)

//func main() {
//	abc :=  make(map[int]string)
//	abc[0] = "Google"
//	abc[1] = "big"
//	abc[2] = "is"
//	abc[3] = "shopping"
//	abc[4] = "company"
//	abc[5] = "search"
//	abc[6] = "engine"
//
//	input := "Googleisbigsearchcompany"
//
//	for _, v := range abc {
//		if strings.Contains(input, v) {
//			input = strings.Replace(input, v, string(v + " "), -1)
//		}
//	}
//	fmt.Println(input)
//}

func main() {
	abc :=  make(map[string][]string)
	abc["g"] = []string{"going", "god","good", "gun", "google"}
	abc["b"] = []string{"big", "bad", "bat", "boat"}
	abc["i"] = []string{"is", "interest", "ink"}
	abc["s"] = []string{"shopping", "satyendra", "sample","search", "shop"}
	abc["c"] = []string{"company", "cat", "can", "career"}
	abc["e"] = []string{"engine", "end", "ear"}

	//input := "googleisbigsearchcompany"
	input := "satyendraisgoinggoogle"
	inputAns := ""
	for _, d := range input {
		wordList, _ := abc[string(d)]
		for _, v := range wordList  {
			if strings.Contains(input, v) {
				inputAns = string(inputAns + v + " ")
				input = strings.Replace(input, v, string(""), -1)
			}
		}
	}
	fmt.Println(inputAns)
}