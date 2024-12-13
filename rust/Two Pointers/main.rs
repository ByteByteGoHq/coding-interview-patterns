mod pair_sum_sorted;
mod pair_sum_sorted_brute_force;

fn main() {
    println!(
        "{:?}",
        pair_sum_sorted_brute_force::pair_sum_sorted_brute_force(&[], 0)
    );
    println!(
        "{:?}",
        pair_sum_sorted_brute_force::pair_sum_sorted_brute_force(&[1], 1)
    );
    println!(
        "{:?}",
        pair_sum_sorted_brute_force::pair_sum_sorted_brute_force(&[2, 3], 5)
    );
    println!(
        "{:?}",
        pair_sum_sorted_brute_force::pair_sum_sorted_brute_force(&[2, 4], 5)
    );
    println!(
        "{:?}",
        pair_sum_sorted_brute_force::pair_sum_sorted_brute_force(&[2, 2, 3], 5)
    );
    println!(
        "{:?}",
        pair_sum_sorted_brute_force::pair_sum_sorted_brute_force(&[-1, 2, 3], 2)
    );
    println!(
        "{:?}",
        pair_sum_sorted_brute_force::pair_sum_sorted_brute_force(&[-3, -2, -1], -5)
    );

    println!("\n");

    println!("{:?}", pair_sum_sorted::pair_sum_sorted(&[1, 2, 3, 4], 5));
}
