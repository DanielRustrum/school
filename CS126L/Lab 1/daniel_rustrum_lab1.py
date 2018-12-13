# Grab Inputs From User and Assign it to a varibles
duration = input("duration: ")
planet_name = input("name: ")
alien_name = input("unusual name: ")
body_part_one = input("body part plural: ")
body_part_two = input("body part plural: ")
body_part_three = input("body part plural: ")
captain_name = input("person name male: ")
suit = input("wearable object: ")
planet_material = input("material: ")
adjective_one = input("adjective: ")
noun = input("noun plural: ")
adjective_two = input("adjective: ")

# Print Title And Empty Line Under and above The Title
print("\n Plan-et \n")

# Set String as varible and then set the string to take arguments
mad_lib_text = "The trip had lasted %s when they arrived on planet \n \
                %s . When they landed they \n \
                encountered the %s Race. They had \n \
                enormous %s, spiky %s and hawk like %s. The aliens \n \
                looked unusual and seemed to blend \n \
                into their environment. The captain of the voyage, Sir %s \n \
                walked out of his ship and stepped foot onto the new world. \n \
                Luckily his %s protected him from the acid fog, \n \
                which enveloped the planet, as it was made of %s . \n \
                The landscape was %s and smelled like %s. \n \
                It was then that %s was eaten by a %s. \n \
                The mission ended in failure and the planet \n \
                was forever called a %s place to be forgotten. " % \
                (duration, planet_name, alien_name,
                 body_part_one, body_part_two, body_part_three,
                 captain_name, suit, planet_material,
                 adjective_one, noun, captain_name, alien_name, adjective_two)

print(mad_lib_text)     # Print Whole String
