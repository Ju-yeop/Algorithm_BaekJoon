import re

def get_representative_names(merchantNames):
    rep_names = []
    cur_store = []
    cur_rep = ''
    merchantNames.sort()

    for name in merchantNames:
        if len(cur_store) == 0 or name.startswith(cur_store[0]):
            cur_store.append(name)
            length = len(name.replace(' ', ''))
            specials = len(re.findall(r'[&().,-]', name))
            if (length >= len(cur_rep.replace(' ', '')) and
                specials > len(re.findall(r'[&().,-]', cur_rep))):
                cur_rep = name
        else:
            rep_names.append(cur_rep)
            cur_store = [name]
            cur_rep = name

    if cur_rep:
        rep_names.append(cur_rep)

    return rep_names