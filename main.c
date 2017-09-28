#include <stdio.h>
#include <stdlib.h>

void merge(int arr[], int prim, int ult, int meio)
{
    int tamEsq = meio - prim + 1;
    int tamDir = ult - meio;

    int esq [tamEsq];
    int dir [tamDir];

    int i;
    for(i = 0; i < tamEsq; i ++)
        esq[i] = arr[prim+i];

    for(i = 0; i < tamDir; i ++)
        dir[i] = arr[meio+1+i];

    int li = 0, ri = 0, ai = prim;
    while(li<tamEsq && ri<tamDir)
    {
        if(esq[li] < dir[ri])
        {
            arr[ai] = esq[li];
            li++;
            ai++;
        }
        else
        {
            arr[ai] = dir[ri];
            ri++;
            ai++;
        }
    }

    for(i = li; i < tamEsq; i ++)
    {
        arr[ai] = esq[i];
        ai++;
    }
    for(i = ri; i < tamDir; i ++)
    {
        arr[ai] = dir[i];
        ai++;
    }
}

void particiona(int arr[], int prim, int ult)
{
    if(prim < ult)
    {
        int meio = (prim + ult)/2;

        particiona(arr, prim, meio);
        particiona(arr, meio+1, ult);

        merge(arr, prim, ult, meio);
    }
}
void printArray(int A[], int size)
{
    int i;
    for (i=0; i < size; i++)
        printf("%d ", A[i]);
    printf("\n");
}

int main()
{
    //int arr[] = {3,195,375,654,0,1,85,56,987,1567,12,56,74,5,4,2,7,9,87,89,321};
    int arr[] = {5,7,8,6,2,0,1};

    printf("Arr:\n");
    printArray(arr, 7);

    particiona(arr, 7, 6);

    printf("Array ordenado: \n");
    printArray(arr, 7);

    return 0;
}
