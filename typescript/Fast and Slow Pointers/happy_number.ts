function happyNumber(n: number): boolean {
    let slow = n, fast = n;
    while (true) {
        slow = getNextNum(slow);
        fast = getNextNum(getNextNum(fast));
        if (fast == 1)
            return true;
        // If the fast and slow pointers meet, a cycle is detected. 
        // Hence, 'n' is not a happy number.
        else if (fast == slow)
            return false;
    }
}

function getNextNum(x: number): number {
    let nextNum = 0;
    while (x > 0){
        // Extract the last digit of 'x'.
        const digit = x % 10;
        // Truncate (remove) the last digit from 'x' using floor 
        // division.
        x /= 10;
        // Add the square of the extracted digit to the sum.
        nextNum += digit ** 2;
    }
    return nextNum;
}
