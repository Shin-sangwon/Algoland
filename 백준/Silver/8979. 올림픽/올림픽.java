import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Country implements Comparable<Country> {

        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            return (o.gold + o.silver + o.bronze == this.gold + this.silver + this.bronze) ?
                (o.gold + o.silver == this.gold + this.silver) ?
                    (o.gold - this.gold) : ((o.gold + o.silver) - (this.gold + this.silver))
                : ((o.gold + o.silver + o.bronze) - (this.gold + this.silver + this.bronze));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Country country = (Country) o;
            return gold == country.gold && silver == country.silver && bronze == country.bronze;
        }

        @Override
        public int hashCode() {
            return Objects.hash(gold, silver, bronze);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        PriorityQueue<Country> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            queue.add(new Country(num, gold, silver, bronze));
        }

        int index = 1;

        while (!queue.isEmpty()) {

            Country country = queue.poll();

            if (target == country.num) {
                System.out.println(index);
                break;
            }

            if (country.equals(queue.peek())) {
                continue;
            } else {
                index++;
            }
        }


    }
}