#Semplice script in Python per cancellare tutti i file .class
import os

def delete_class_files(directory):
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file.endswith(".class"):
                file_path = os.path.join(root, file)
                os.remove(file_path)
                print(f"File eliminato: {file_path}")

directory_path = "/Users/macbookpro/workspaces/Prog2"
#Mettete la vostra Path
delete_class_files(directory_path)