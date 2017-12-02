public class Day01 {

	public static void main(String[] args) {
		int sum1 = 0, sum2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == arr[(i + 1) % arr.length]) {
				sum1 += Integer.valueOf(String.valueOf(arr[i]));
			}
			if (arr[i] == arr[(i + arr.length / 2) % arr.length]) {
				sum2 += Integer.valueOf(String.valueOf(arr[i]));
			}
		}
		System.out.println(sum1 + " - " + sum2);
	}

	private static char[] arr =
		 ("572762743879445378236526261778533844111463253844949359244543366119531191736381916713262548326248415934216676834"
		+ "743491546681777434377459654616786366318635414628935476168779149146623588363654211985162633359265447163318141252"
		+ "957125811583993213726837427734236262866697594159593913747442145956827958186155326738778684241969264977311443197"
		+ "364451417281233229625472885724345641784927536818422448883685424238322282111728424562312757381827642322659336251"
		+ "193125981611921932148989492677654174683489351346189646831271943917961653681455488144731298576979893226213687447"
		+ "256851833468253332478667347358944933952187814643469517778739298989613587962748898268945295996454426574234385624"
		+ "238532475436215654688197999315987547534675938323281474393415861252627337371283869615963947281597192927875974268"
		+ "989451987882114178546629483584227294713124564377789787497539272514316775335757523124474883371569562174519656434"
		+ "544453297583271299666571893328249691414485386819796326111993858969659468497254219781377533662524599149136378587"
		+ "831467354697587167527657181891755839564769351859859185363184242484254263981582781117517119112278188267661779962"
		+ "237188374289727843289257438698852322661277278652678815923956438369992442183451844746131298239336594222236854227"
		+ "321865361991539887174555685237816733936983569673558751235547977554911817915931564337355915294959842565196311878"
		+ "496546332432251181321525497126432738193144338775926446938268615232439469986157229511824747731732155275989495531"
		+ "853132599922278799644821217696172186853947767784233781824624227882779975239131763264689573422963681783219586261"
		+ "687855789774145373686864383481242837897487751638214576411351634956493311444361578366479128524831775422248649522"
		+ "718746452745724264586143849179236236275324876253969141115827549539449654625766247288969171375997788287699586267"
		+ "886853747496617412237418348446437254869258869331183826495814813518449433684848539567598772152527662948964964448"
		+ "352643571696423412914127689465897818124934213795755695936783542412233637391298136332369965887117919194215745839"
		+ "247431198676222296592117934687441632974789524759331632597695783458943678555342944936137675644971373699693151924"
		+ "43795512585").toCharArray();

}