counter = 0;
counter2 = 0;

function fizzbuzz(number)
{
    buzz = counter === 5;
    fizz = counter2 === 3;
    if(fizz && buzz)
    {
        console.log("fizzbuzz")
        counter = 0;
        counter2 = 0;
    }
    else if(buzz) {
        console.log("buzz");
        counter = 0;
    }

    else if(fizz) {
        console.log("fizz");
        counter2 = 0;

    }
    else {
        console.log(number)
    }
}


for(index = 0;index < 100;index++)
{
    fizzbuzz(index)
    counter++;
    counter2++;

}