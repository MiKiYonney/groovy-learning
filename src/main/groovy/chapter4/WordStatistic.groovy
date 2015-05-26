package chapter4

/**
 * Created by yonney.yang on 2015/5/8.
 */
def text = "add,back,test,oo,plou,ni,mi,mi,whjuaduashduiahsi,dhsufhusad,wrioreojuo";
def words = text.tokenize(",");
def wordFrequency = [:]
words.each {
    word -> wordFrequency[word] =wordFrequency.get(word,0)+1
}
def wordList = wordFrequency.keySet().toList();
wordList.sort{
    wordFrequency[it]
}
/*  def statistic = "\n"
  wordList[-1..-6].each {
      word -> statistic += word.padLeft(12)+": "
          statistic += wordFrequency[word] + "\n"
  }*/
def statistic = "\n"
wordList.each {
    key ->
        statistic += key+": ";
        statistic += +wordFrequency[key] + "\n";
}
println statistic;
