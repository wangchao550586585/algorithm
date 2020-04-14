package 贪心.区间选点;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 会场安排问题1 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int num, i, j;
		PriorityQueue<Note> notes;
		Note[] noteArray;
		while (total-- > 0) {
			num = Integer.parseInt(br.readLine());
			notes = new PriorityQueue<Note>(11, comparator);
			noteArray = new Note[num];
			Note tempNote = null;
			for (i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				tempNote = new Note(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
				noteArray[i] = tempNote;
			}

			for (i = 0; i < noteArray.length; i++) {
				tempNote = noteArray[i];
				for (j = 0; j < noteArray.length; j++) {
					if (tempNote.start <= noteArray[j].start
							&& tempNote.end >= noteArray[j].end
							&& noteArray[j] != tempNote) {
						tempNote = null;
						break;
					}
				}
				if (tempNote != null)
					notes.add(tempNote);
			}

			tempNote = null;
			int result = 0;
			while (!notes.isEmpty()) {
				if (tempNote == null) {
					tempNote = notes.poll();
					result++;
				} else {
					if (notes.peek().start > tempNote.end) {
						tempNote = notes.poll();
						result++;
					} else
						notes.poll();
				}
			}

			System.out.println(result);

		}

	}

	static Comparator<Note> comparator = new Comparator<Note>() {
		public int compare(Note o1, Note o2) {
			int numbera = o1.start;
			int numberb = o2.start;
			return numbera - numberb;
		}
	};

	static class Note {

		public int start;
		public int end;

		public Note(int s, int e) {
			start = s;
			end = e;
		}

	}

}
