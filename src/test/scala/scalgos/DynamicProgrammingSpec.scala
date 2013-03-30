package scalgos

import org.specs2.mutable._

import scalgos.DynamicProgramming._

class DynamicProgrammingSpec extends Specification {

  "validBrackets" should {
    "be list containing empty string for 0" in {
      validBrackets(0) must be equalTo(Seq(""))
    }
    "work for arbitrary input" in {
      validBrackets(1) must be equalTo(Seq("()"))
      validBrackets(2) must contain("()()", "(())").only
      validBrackets(3) must contain("()()()", "()(())", "(())()", "((()))", "(()())").only
    }
    // TODO: catlan number match
  }

  "maxRectangleUnderHistogram" should {
    "be 0 for empty histograms" in { maxRectangleInHistogram(Nil) must be equalTo(0) }

    "work for arbitrary input" in {
      val dims = Seq((6, 1), (3, 5), (8, 1), (4, 9), (5, 3), (8, 2), (1, 18), (2, 2), (19, 1), (2, 10))
      maxRectangleInHistogram(dims) must be equalTo 58
    }
  }

  "longestCommonSubsequence" should {
    "be Nil if one of the input is empty" in {
      {longestCommonSubsequence("hello", "") must be empty}
      {longestCommonSubsequence("", "nastenka") must be empty}
      {longestCommonSubsequence("", "") must be empty}
    }
    "be Nil if nothing in common" in {
      longestCommonSubsequence("abcdef", "ghijklmonopqr") must be empty
    }
    "work for arbitrary input" in {
      longestCommonSubsequence("patrick", "pathikrit") must be equalTo("patik")
    }
  }

  "longestIncreasingSubsequence" should {
    "be Nil for empty sequence" { failure }.pendingUntilFixed
    "be Nil for decreasing sequence" { failure }.pendingUntilFixed
    "be same same as longestCommonSubsequence with sorted input" { failure }.pendingUntilFixed
  }
}
