import time


# define Update and set its arguments
def update(book, status, audience, name):
    # Get timestamp
    timestamp = round(time.time())
    # Define Unique Identification
    uid = name + '_' + str(timestamp)
    # Define Likes
    likes = []
    # set status, audience, and name in book
    book[uid] = [audience, status, likes, uid]
    # Send Output Message
    print(" Post made at %s by %s" % (timestamp, name))
    # Return unique Identification
    return uid


def like(book, uid, name):
    # Add name to book
    book[uid][2].append(name)


def unlike(book, uid, name):
    # Try to execute removal
    try:
        book[uid][2].remove(name)
    # Otherwise ignore function
    except ValueError:
        pass


def display(book, uid):
    # Grab Name and time stamp
    format_name = book[uid][3].split('_')
    # Print book values
    print("\t Time:", format_name[1], "\n"
          '\t Groups: ', book[uid][0], '\n'
          '\t Likes:', len(book[uid][2]), '\n'
          '\t', format_name[0], '(mention with @' + format_name[0] + ") says:\n"
          '\t', book[uid][1], '\n')


def main():
    # Initialize your empty ’book’ variable before running the code below.
    book = {}
    # BarnabasCollins is adding the first post to the book variable . The posted
    #  says’Storming the village at 9. Anyone interested?", and is intended
    barnabas_one = update(book, "Storming␣the␣village␣at␣9.␣␣Anyone␣interested?",
                          ["Zombies", "Vampires"],
                          "BarnabasCollins")
    # some time goes by
    time.sleep(1)
    # Casper posts asking the Vampires if he can come along.
    casper_one = update(book,
                        "Can␣ I ␣come?",
                        ["Vampires"],
                        "Casper")
    time.sleep(1)
    barnabas_two = update(book,
                          "Forgot␣to␣include␣the␣ghosts !␣LOL",
                          ["Ghosts"], "BarnabasCollins")
    time.sleep(1)
    barnabas_three = update(book, "Lots␣of␣villagers␣with␣forks␣here..",
                            ["Vampires", "Zombies", "Ghosts"], "BarnabasCollins")
    # Edmund and Grimm like Barnabas ’ first post
    like(book, barnabas_one, "Edmund")
    like(book, barnabas_one, "Grimm")
    like(book, barnabas_one, "Edmund")
    # 4 diffrent undead people like Capser ’s first post
    like(book, casper_one, "Edmund")
    like(book, casper_one, "Grimm")
    like(book, casper_one, "Harry")
    like(book, casper_one, "Count␣Chocula")
    # Casper likes Barnabas ’ second post
    like(book, barnabas_two, "Casper")
    # Second post
    like(book, barnabas_three, "Casper")
    like(book, barnabas_three, "Count␣Chocula")
    like(book, barnabas_three, "Boo")
    # unlikes ...
    unlike(book, casper_one, "Edmund")
    unlike(book, barnabas_three, "Casper")
    unlike(book, casper_one, "Edmund")
    # display some of the posts
    display(book, barnabas_one)
    display(book, barnabas_three)
    print("−−−")
    display(book, casper_one)

# Call main
main()
