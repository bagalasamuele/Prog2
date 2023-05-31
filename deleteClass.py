#Semplice script in Python per cancellare tutti i file .class e .DS_Store
import os

def delete_files(directory, extensions):
    deleted_files = []
    for root, dirs, files in os.walk(directory):
        for file in files:
            _, ext = os.path.splitext(file)
            if ext.lower() in extensions:
                file_path = os.path.join(root, file)
                os.remove(file_path)
                deleted_files.append(file_path)
    return deleted_files

directory = '/Users/macbookpro/workspaces/Prog2'
#Mettete la vostra Path

extensions = ['.class', '.DS_Store']

deleted_files = delete_files(directory, extensions)

print("File eliminati:")
for file in deleted_files:
    print(file)
