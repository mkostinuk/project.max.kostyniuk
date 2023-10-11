package com.kostyniuk;

import com.kostyniuk.CLI.Combination;

public class Main {


	public static void main(String[] args) {
		Combination combinationClasses;
		combinationClasses=(args.length>0)?
				new Combination(args): new Combination();
		combinationClasses.connecting();
	}
}











