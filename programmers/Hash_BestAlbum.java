package programmers;

/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://programmers.co.kr/learn/courses/30/lessons/42579
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Hash_BestAlbum {

	public static void main(String[] args) {

		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		
		int[] answer = solution(genres, plays);

		for(int idx = 0; idx < answer.length; idx++) {
			System.out.print(answer[idx]+" ");

		}

	}
	
	// before test, have to delete 'static' keywords
	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> genresCheck = new HashMap<String, Integer>();
		HashMap<String, Integer> inputCheck = new HashMap<String, Integer>();
		ArrayList<Song> songList = new ArrayList<Song>();
		ArrayList<Integer> outputList = new ArrayList<Integer>();
		//1. genres count
		
		
		
		for(int g_idx = 0; g_idx < genres.length; g_idx++) {

			String g_str = genres[g_idx];
			songList.add(new Song(g_str,plays[g_idx],g_idx));
			
			if(genresCheck.containsKey(g_str)) {
				genresCheck.put(g_str, genresCheck.get(g_str)+plays[g_idx]);
			} else {
				
				genresCheck.put(g_str, plays[g_idx]);
			}
			
		}
		//2. sort
		
		Collections.sort(songList, new Comparator<Song>() {
			
			//s1 new
			@Override
			public int compare(Song s1, Song s2) {
				
				if(s1.genresName.equals(s2.genresName)) {
					
					if(s1.playCount != s2.playCount) {
						return - (s1.playCount - s2.playCount);
					} else {
						
						return (s1.songNum - s2.songNum);
					}
					
				} else {
					
					return -(genresCheck.get(s1.genresName) - genresCheck.get(s2.genresName));
					
				}
				
			}
			
			
		}); 
		//3.checking
		for(int idx = 0; idx < songList.size(); idx++) {
			
			Song song = songList.get(idx);
			
			if(!inputCheck.containsKey(song.genresName)) {
				inputCheck.put(song.genresName, 1);
				outputList.add(song.songNum);
			} else {
				
				int cnt = inputCheck.get(song.genresName);
				
				if(cnt > 1) {
					continue;
				} else {
					inputCheck.put(song.genresName, cnt+1);
					outputList.add(song.songNum);

				}
				
			}
			
		}
		
		int[] answer = new int[outputList.size()];
		
		for(int s_idx = 0; s_idx < answer.length; s_idx++) {
			answer[s_idx] = outputList.get(s_idx);
		}


		return answer;
	}

	static class Song {
		
		String genresName;
		int playCount;
		int songNum;

		public Song(String genresName, int playCount, int songNum) {
			
			this.genresName = genresName;
			this.playCount = playCount;
			this.songNum = songNum;

		}

	}

}
