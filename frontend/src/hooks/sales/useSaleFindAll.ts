import { AxiosResponse } from 'axios';
import { api } from '../../api';
import { Sale } from '../../types/TypeSale';

const useSaleFindAll = async (): Promise<AxiosResponse> => {
  const response: AxiosResponse<Sale> = await api({
    method: 'GET',
    url: '/sales',
    params: {
      page: 0,
      size: 12
    }
  });
  // console.log(response.data);
  return response;
};

export { useSaleFindAll };
