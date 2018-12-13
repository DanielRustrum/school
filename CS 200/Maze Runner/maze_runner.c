#include <stdlib.h>
#include <stdio.h>
#include "mazelib.h"
#include "runner.h"

void usage(void);

int main(int argc, char* argv[]) {
  if (argc < 3) {
    usage();
    return 1;
  } else {
    int width = (int) strtol(argv[1], NULL, 10);
    int height = (int) strtol(argv[2], NULL, 10);

    if(!maze_init(width, height)) {
      usage();
      return 1;
    }
  }

  maze_print();
  printf("\n\n\n");
  runner_init();
  runner_solve();
  maze_print();
  return 0;
}

// This function displays the usage message if the parameters are missing or incorrect.
void usage(void) {
  printf("Usage: maze_runner width height \n");
  printf("\t width must be an odd integer between 9 and 79 inclusive\n");
  printf("\t height must be an odd integer between 9 and 25 inclusive\n\n");
}
