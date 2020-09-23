package com.fetch.exercise.pyramid.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.fetch.exercise.pyramid.model.Pyramid;

@Service
public class PyramidService {

	/**
	for input banana, pyramid will look like:
			b		1
		  n	  n		2
	    a   a   a	3
	    letters have frequency as
	    b=1, n=2, a=3	
	    when a word is a pyramid word, the multiplication of all of the letter's 
	    frequencies has to be the factorial of the height of the pyramid
	    hence, f(a)*f(n)*f(b) = 3!
		If the word was llbananalll, then
			b			1
		  n	  n			2
	    a   a   a		3
	l   l   l   l   l	5
	 f(a)*f(n)*f(b)*f(l) != 4!   Hence the word is not a pyramid word.
	 
	*/

	public Pyramid isPyramid(String p) {
		if(p == null || p.isEmpty()) {
			return new Pyramid(null, false);
		}
		Map<Character, Integer> frequencyMap = getCharFrequencyMap(p);
		long pyramidHeight = frequencyMap.size();
		long expectedMultiplication = factorial(pyramidHeight);
		long actualMultiplication = 1;
		for (Iterator iterator = frequencyMap.entrySet().iterator(); iterator.hasNext();) {
			Entry<Character, Integer> entry = (Entry<Character, Integer>) iterator.next();
			actualMultiplication *= entry.getValue();
		}
		return new Pyramid(p, actualMultiplication == expectedMultiplication);
	}
	
	private Map<Character, Integer> getCharFrequencyMap(String s){
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			if(frequencyMap.containsKey(s.charAt(i))) {
				frequencyMap.put(s.charAt(i), frequencyMap.get(s.charAt(i))+1);
			}else {
				frequencyMap.put(s.charAt(i), 1);
			}
		}
		return frequencyMap;
	}
	
	public static long factorial(long n) {
		if(n <= 1) {
			return 1;
		}else {
			return n * factorial(n-1);
		}
	}
}
